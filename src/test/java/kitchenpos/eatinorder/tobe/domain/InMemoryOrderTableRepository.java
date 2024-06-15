package kitchenpos.eatinorder.tobe.domain;

import kitchenpos.eatinorder.tobe.domain.ordertable.OrderTable;
import kitchenpos.eatinorder.tobe.domain.ordertable.OrderTableRepository;

import java.util.*;

public class InMemoryOrderTableRepository implements OrderTableRepository {
    private final Map<UUID, OrderTable> orderTables = new HashMap<>();

    @Override
    public OrderTable save(final OrderTable orderTable) {
        orderTables.put(orderTable.getId(), orderTable);
        return orderTable;
    }

    @Override
    public Optional<OrderTable> findById(final UUID id) {
        return Optional.ofNullable(orderTables.get(id));
    }

    @Override
    public List<OrderTable> findAll() {
        return new ArrayList<>(orderTables.values());
    }
}
