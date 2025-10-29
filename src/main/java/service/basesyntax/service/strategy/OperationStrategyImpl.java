package service.basesyntax.service.strategy;

import java.util.Map;
import service.basesyntax.model.FruitTransaction;
import service.basesyntax.service.handler.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (map.get(operation) == null) {
            throw new RuntimeException("Operation " + operation + " not found");
        }
        return map.get(operation);
    }

    public Map<FruitTransaction.Operation, OperationHandler> getMap() {
        return map;
    }

}
