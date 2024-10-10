package org.example;

import java.util.List;

public class TransactionReportGenerator {

    public void generateReport(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() + " - " + transaction.getDescription() + " : " + transaction.getAmount());
        }
    }
}
