package service.basesyntax.service.strategy;

import service.basesyntax.service.handler.OperationHandler;
import service.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler getHandler(FruitTransaction.Operation operation);
}
