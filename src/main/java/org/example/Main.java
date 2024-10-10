package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv"; // URL до файлу
        TransactionCSVReader csvReader = new TransactionCSVReader();
        List<Transaction> transactions = csvReader.readTransactions(filePath);

        if (!transactions.isEmpty()) {
            TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
            double totalBalance = analyzer.calculateTotalBalance();
            System.out.println("Загальний баланс: " + totalBalance);

            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Не вдалося прочитати жодної транзакції.");
        }
    }
}