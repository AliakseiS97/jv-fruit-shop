package service.basesyntax.service.strategy;

import java.util.Map;
import service.basesyntax.db.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        if (storage == null) {
            throw new NullPointerException("storage is null");
        }
        if (transaction == null) {
            throw new NullPointerException("transaction is null");
        }
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(),
                        0) + transaction.getQuantity());
    }
}
