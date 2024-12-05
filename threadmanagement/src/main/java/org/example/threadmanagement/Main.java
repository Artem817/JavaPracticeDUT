package org.example.threadmanagement;

import org.example.orderprocessing.OrderProcessor;
import org.example.orderstorage.Clothing;
import org.example.orderstorage.Electronics;
import org.example.orderstorage.Product;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Product> orders = new ArrayList<>();

        Electronics electronicsOrder = Electronics.builder()
                .id("E001")
                .name("Car")
                .price(15000.0)
                .brand("Tesla")
                .model("ModelX")
                .build();

        Clothing clothingOrder = Clothing.builder()
                .id("C001")
                .name("T-Shirt")
                .price(25.0)
                .size("M")
                .color("Blue")
                .build();

        orders.add(electronicsOrder);
        orders.add(clothingOrder);

        OrderProcessor<Product> processor = new OrderProcessor<>(orders);
        processor.processOrders(order -> System.out.println("Processing order: " + order.getName()));
    }
}
