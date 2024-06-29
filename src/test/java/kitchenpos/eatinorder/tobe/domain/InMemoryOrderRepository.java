package kitchenpos.eatinorder.tobe.domain;

import java.util.*;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<UUID, EatInOrder> orders = new HashMap<>();

    @Override
    public EatInOrder save(EatInOrder order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<EatInOrder> findById(final UUID id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<EatInOrder> findAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public boolean existsByOrderTableAndStatusNot(final UUID orderTableId, final EatInOrderStatus status) {
        return orders.values()
                .stream()
                .anyMatch(order -> order.getOrderTableId().equals(orderTableId) && order.getStatus() != status);
    }

}
