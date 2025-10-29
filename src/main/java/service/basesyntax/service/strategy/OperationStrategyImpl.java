package service.basesyntax.service.strategy;

import service.basesyntax.service.handler.OperationHandler;
import service.basesyntax.model.FruitTransaction;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (map.get(operation) == null) {
            throw new RuntimeException("Operation " + operation + " not found");
        }
        return map.get(operation);
    }

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getMap() {
        return map;
    }

}
