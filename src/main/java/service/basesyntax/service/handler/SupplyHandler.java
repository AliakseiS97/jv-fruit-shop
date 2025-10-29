package service.basesyntax.service.handler;

import java.util.Map;
import service.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(),
                        0) + transaction.getQuantity());
    }
}
