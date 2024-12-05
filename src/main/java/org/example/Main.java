package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники", accessories);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

        while (true) {
            System.out.println("\nЩо ви хочете зробити?");
            System.out.println("1. Показати кошик");
            System.out.println("2. Видалити товар");
            System.out.println("3. Пошук товару за назвою");
            System.out.println("4. Пошук товару за категорією");
            System.out.println("5. Завершити роботу");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(cart);
                    break;

                case 2:
                    System.out.println("Введіть назву товару, який потрібно видалити:");
                    String productNameToRemove = scanner.nextLine();
                    Product productToRemove = findProductByName(cart, productNameToRemove);
                    if (productToRemove != null) {
                        cart.removeProduct(productToRemove);
                        System.out.println("Товар \"" + productToRemove.getName() + "\" видалено з кошика.");
                    } else {
                        System.out.println("Товар з такою назвою не знайдено.");
                    }
                    break;

                case 3:
                    System.out.println("Введіть назву товару для пошуку:");
                    String productNameToSearch = scanner.nextLine();
                    List<Product> foundProducts = cart.searchByName(productNameToSearch);
                    if (!foundProducts.isEmpty()) {
                        System.out.println("Знайдені товари:");
                        foundProducts.forEach(System.out::println);
                    } else {
                        System.out.println("Товари з такою назвою не знайдені.");
                    }
                    break;

                case 4:
                    System.out.println("Введіть назву категорії для пошуку:");
                    String categoryNameToSearch = scanner.nextLine();
                    Category categoryToSearch = findCategoryByName(categoryNameToSearch, electronics, smartphones, accessories);
                    if (categoryToSearch != null) {
                        List<Product> productsByCategory = cart.searchByCategory(categoryToSearch);
                        if (!productsByCategory.isEmpty()) {
                            System.out.println("Знайдені товари:");
                            productsByCategory.forEach(System.out::println);
                        } else {
                            System.out.println("Товари в цій категорії не знайдені.");
                        }
                    } else {
                        System.out.println("Категорію з такою назвою не знайдено.");
                    }
                    break;

                case 5:
                    System.out.println("Завершення роботи...");
                    return;

                default:
                    System.out.println("Невірна команда. Спробуйте ще раз.");
            }
        }
    }

    private static Product findProductByName(Cart cart, String name) {
        return cart.getProducts().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private static Category findCategoryByName(String name, Category... categories) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }
        return null;
    }
}
