package service.basesyntax.service.handler;

import java.util.Map;
import service.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(Map<String, Integer> storage, FruitTransaction transaction);
}
