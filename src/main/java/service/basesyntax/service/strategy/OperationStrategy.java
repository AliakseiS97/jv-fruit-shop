package service.basesyntax.service.strategy;

import service.basesyntax.model.FruitTransaction;
import service.basesyntax.service.handler.OperationHandler;

public interface OperationStrategy {
    public OperationHandler getHandler(FruitTransaction.Operation operation);
}
