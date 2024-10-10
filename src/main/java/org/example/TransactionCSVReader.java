package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TransactionCSVReader {
    public List<Transaction> readTransactions(String csvUrl) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            URL url = new URL(csvUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String date = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    String description = parts[2];
                    transactions.add(new Transaction(date, amount, description));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}