package org.example;

public class Calculator {
    public double add(double a, double b) throws InvalidInputException {
        checkInput(a, b);
        return a + b;
    }

    public double subtract(double a, double b) throws InvalidInputException {
        checkInput(a, b);
        return a - b;
    }

    public double multiply(double a, double b) throws InvalidInputException {
        checkInput(a, b);
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException, InvalidInputException {
        checkInput(a, b);
        if (b == 0) {
            throw new ArithmeticException("Помилка: ділення на нуль!");
        }
        return a / b;
    }

    private void checkInput(double a, double b) throws InvalidInputException {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new InvalidInputException("Введено некоректне значення!");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new InvalidInputException("Значення не повинні бути нескінченними!");
        }
    }
}
