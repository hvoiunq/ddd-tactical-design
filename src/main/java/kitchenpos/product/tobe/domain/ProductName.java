package kitchenpos.product.tobe.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import kitchenpos.exception.IllegalNameException;
import kitchenpos.infra.PurgomalumClient;

import java.util.Objects;

@Embeddable
public class ProductName {

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    private PurgomalumClient purgomalumClient;

    protected ProductName() {
    }

    public ProductName(String productName, PurgomalumClient purgomalumClient) {
        this.name = productName;
        this.purgomalumClient = purgomalumClient;
        validate();
    }

    private void validate() {
        if (Objects.isNull(name)) {
            throw new IllegalNameException(null);
        }
        if (purgomalumClient.containsProfanity(name)) {
            throw new IllegalNameException("(비속어 포함 이름) " + name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductName that = (ProductName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
