package service.basesyntax.service.strategy;

import java.util.Map;
import service.basesyntax.db.FruitTransaction;

public interface OperationHandler {
    void apply(Map<String, Integer> storage, FruitTransaction transaction);
}
