package kitchenpos.eatinorder.tobe.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    EatInOrder save(EatInOrder order);

    Optional<EatInOrder> findById(UUID id);

    List<EatInOrder> findAll();

    boolean existsByOrderTableAndStatusNot(UUID orderTable, EatInOrderStatus status);
}

