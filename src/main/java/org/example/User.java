package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String name;
    private List<Order> orderHistory = new ArrayList<>();

    public void addOrder(Order order) {
        this.orderHistory.add(order);
    }
}
