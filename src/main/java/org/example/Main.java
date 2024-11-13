package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.print("Введіть перше число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введіть друге число: ");
            double num2 = scanner.nextDouble();

            System.out.print("Виберіть операцію (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            double result = 0;
            switch (operation) {
                case '+':
                    result = calculator.add(num1, num2);
                    break;
                case '-':
                    result = calculator.subtract(num1, num2);
                    break;
                case '*':
                    result = calculator.multiply(num1, num2);
                    break;
                case '/':
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    System.out.println("Невідома операція!");
                    return;
            }
            System.out.println("Результат: " + result);

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Помилка: введено некоректне значення.");
        } finally {
            System.out.println("Завершення роботи програми.");
            scanner.close();
        }
    }
}