package org.example;

import java.util.List;

public class TransactionAnalyzer {
    private List<Transaction> transactions;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double calculateTotalBalance() {
        double totalBalance = 0;
        for (Transaction transaction : transactions) {
            totalBalance += transaction.getAmount();
        }
        return totalBalance;
    }

    // Додаємо метод analyze
    public void analyze(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
