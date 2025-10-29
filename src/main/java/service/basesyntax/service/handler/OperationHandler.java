package service.basesyntax.service.handler;

import service.basesyntax.model.FruitTransaction;

import java.util.Map;

public interface OperationHandler {
    void apply(Map<String, Integer> storage, FruitTransaction transaction);
}
