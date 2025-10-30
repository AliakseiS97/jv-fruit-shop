package service.basesyntax.service.strategy;

import service.basesyntax.db.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
