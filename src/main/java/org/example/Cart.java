package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void clear() {
        this.products.clear();
    }

    public double getTotalPrice() {
        return this.products.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> searchByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> searchByCategory(Category category) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getCategory().equals(category)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        for (Product product : this.products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append(String.format("Загальна вартість: %.2f грн", this.getTotalPrice()));
        return sb.toString();
    }
}
