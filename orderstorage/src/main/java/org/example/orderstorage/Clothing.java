package org.example.orderstorage;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Clothing extends Product {
    private final String size;
    private final String color;
}
