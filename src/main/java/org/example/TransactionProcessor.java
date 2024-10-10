package org.example;

import java.util.List;

public class TransactionProcessor {

    private TransactionCSVReader reader;
    private TransactionAnalyzer analyzer;
    private TransactionReportGenerator reportGenerator;

    public TransactionProcessor(TransactionCSVReader reader, TransactionAnalyzer analyzer, TransactionReportGenerator reportGenerator) {
        this.reader = reader;
        this.analyzer = analyzer;
        this.reportGenerator = reportGenerator;
    }

    public void process(String csvFilePath) {
        List<Transaction> transactions = reader.readTransactions(csvFilePath);

        double totalBalance = analyzer.calculateTotalBalance();

        reportGenerator.generateReport(transactions);
    }
}
