package service.basesyntax.service;

import service.basesyntax.model.FruitTransaction;

public class TransactionParserImpl implements TransactionParser {
    @Override
    public FruitTransaction parse(String lines) {
        String[] parts = lines.split(",");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid line format: " + lines);
        }

        FruitTransaction fruitTransaction = new FruitTransaction();

        fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(parts[0].trim()));
        fruitTransaction.setFruit(parts[1].trim());
        fruitTransaction.setQuantity(Integer.parseInt(parts[2].trim()));
        return fruitTransaction;
    }
}

