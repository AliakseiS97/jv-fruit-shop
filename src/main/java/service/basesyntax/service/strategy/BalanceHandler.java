package service.basesyntax.service.strategy;

import java.util.Map;
import service.basesyntax.db.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        if (storage == null) {
            throw new NullPointerException("storage is null");
        }
        if (transaction == null) {
            throw new NullPointerException("transaction is null");
        }
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
