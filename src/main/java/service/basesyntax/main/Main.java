package service.basesyntax.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.basesyntax.model.FruitTransaction;
import service.basesyntax.model.Storage;
import service.basesyntax.service.ReaderServiceImpl;
import service.basesyntax.service.ShopService;
import service.basesyntax.service.ShopServiceImpl;
import service.basesyntax.service.TransactionParser;
import service.basesyntax.service.TransactionParserImpl;
import service.basesyntax.service.TransactionReaderService;
import service.basesyntax.service.WriterServiceImpl;
import service.basesyntax.service.handler.BalanceHandler;
import service.basesyntax.service.handler.OperationHandler;
import service.basesyntax.service.handler.PurchaseHandler;
import service.basesyntax.service.handler.ReturnHandler;
import service.basesyntax.service.handler.SupplyHandler;
import service.basesyntax.service.strategy.OperationStrategyImpl;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/reportToWrite.csv";

    public static void main(String[] args) {

        ReaderServiceImpl readerService = new ReaderServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        TransactionReaderService transactionReader =
                new TransactionReaderService(readerService, transactionParser);

        Map<FruitTransaction.Operation, OperationHandler> storageStrategy = new HashMap<>();
        storageStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        storageStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        storageStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        storageStrategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(storageStrategy);

        Storage storage = new Storage();
        List<FruitTransaction> transactions = transactionReader.readTransactions(PATH_TO_READ);
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        WriterServiceImpl writerService = new WriterServiceImpl();
        writerService.write(storage.getStorage(), PATH_TO_WRITE);
    }
}
