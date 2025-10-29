package service.basesyntax.main;

import service.basesyntax.model.FruitTransaction;
import service.basesyntax.model.Storage;
import service.basesyntax.service.ReaderService;
import service.basesyntax.service.ShopService;
import service.basesyntax.service.ShopServiceImpl;
import service.basesyntax.service.WriterService;
import service.basesyntax.service.handler.*;
import service.basesyntax.service.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static String PATH_TO_READ = "src/main/resources/reportToRead.csv";
    private final static String PATH_TO_WRITE = "src/main/resources/reportToWrite.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderService();
        List<FruitTransaction> transactions = readerService.readFromFile(PATH_TO_READ);

        Map<FruitTransaction.Operation, OperationHandler> storageStrategy = new HashMap<>();
        storageStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        storageStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        storageStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        storageStrategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(storageStrategy);

        Storage storage = new Storage();

        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        WriterService writerService = new WriterService();
        writerService.write(??????, PATH_TO_WRITE);
    }
}
