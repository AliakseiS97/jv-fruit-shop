package service.basesyntax.service;

import java.util.List;
import service.basesyntax.model.FruitTransaction;
import service.basesyntax.model.Storage;
import service.basesyntax.service.handler.OperationHandler;
import service.basesyntax.service.strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationHandler handler = operationStrategy.getHandler(operation);
            handler.apply(storage.getStorage(), transaction);
        }
    }
}
