package org.example.orderprocessing;

import org.example.orderstorage.Product;

import java.util.List;
import java.util.function.Consumer;

public class OrderProcessor<T extends Product> {
    private final List<T> orders;

    public OrderProcessor(List<T> orders) {
        this.orders = orders;
    }

    public void processOrders(Consumer<T> action) {
        orders.forEach(action);
    }
}
