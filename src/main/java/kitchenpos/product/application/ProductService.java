package kitchenpos.product.application;

import kitchenpos.infra.PurgomalumClient;
import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.MenuProduct;
import kitchenpos.menu.domain.MenuRepository;
import kitchenpos.product.tobe.domain.Product;
import kitchenpos.product.tobe.domain.ProductRepository;
import kitchenpos.product.tobe.domain.ProductName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final MenuRepository menuRepository;
    private final PurgomalumClient purgomalumClient;

    public ProductService(
        final ProductRepository productRepository,
        final MenuRepository menuRepository,
        final PurgomalumClient purgomalumClient
    ) {
        this.productRepository = productRepository;
        this.menuRepository = menuRepository;
        this.purgomalumClient = purgomalumClient;
    }

    @Transactional
    public Product create(final Product request) {
        final String name = request.getProductName().getName();
        final BigDecimal price = request.getProductPrice();

        final Product product = new Product(new ProductName(name, checkContainsProfanity(name)), price);
        return productRepository.save(product);
    }

    boolean checkContainsProfanity(String name) {
        return purgomalumClient.containsProfanity(name);
    }

    @Transactional
    public Product changePrice(final UUID productId, final Product request) {
        final BigDecimal price = request.getProductPrice();
        if (Objects.isNull(price) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        final Product product = productRepository.findById(productId)
            .orElseThrow(NoSuchElementException::new);
        product.setPrice(price);
        final List<Menu> menus = menuRepository.findAllByProductId(productId);
        for (final Menu menu : menus) {
            BigDecimal sum = BigDecimal.ZERO;
            for (final MenuProduct menuProduct : menu.getMenuProducts()) {
                sum = sum.add(
                    menuProduct.getProduct()
                        .getPrice()
                        .multiply(BigDecimal.valueOf(menuProduct.getQuantity()))
                );
            }
            if (menu.getPrice().compareTo(sum) > 0) {
                menu.setDisplayed(false);
            }
        }
        return product;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
