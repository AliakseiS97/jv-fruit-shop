package service.basesyntax.service;

import service.basesyntax.model.FruitTransaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderService {
    public List<FruitTransaction> readFromFile(String path) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].trim().length() == 1) {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(parts[0].trim()));
                    fruitTransaction.setFruit(parts[1].trim());
                    fruitTransaction.setQuantity(Integer.parseInt(parts[2].trim()));
                    transactions.add(fruitTransaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + path, e);
        }
        return transactions;
    }
}
