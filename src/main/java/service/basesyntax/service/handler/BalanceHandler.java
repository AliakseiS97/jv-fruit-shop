package service.basesyntax.service.handler;

import service.basesyntax.model.FruitTransaction;

import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
