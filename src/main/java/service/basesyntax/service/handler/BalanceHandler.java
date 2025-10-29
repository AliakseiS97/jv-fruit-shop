package service.basesyntax.service.handler;

import java.util.Map;
import service.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
