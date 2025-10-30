package service.basesyntax.service;

import service.basesyntax.db.FruitTransaction;

public interface TransactionParser {
    FruitTransaction parse(String lines);
}
