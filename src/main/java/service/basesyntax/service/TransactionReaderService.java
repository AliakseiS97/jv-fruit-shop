package service.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import service.basesyntax.model.FruitTransaction;

public class TransactionReaderService {
    private final ReaderService readerService;
    private final TransactionParser transactionParser;

    public TransactionReaderService(ReaderService readerService,
                                    TransactionParser transactionParser) {
        this.readerService = readerService;
        this.transactionParser = transactionParser;
    }

    public List<FruitTransaction> readTransactions(String path) {
        List<String> lines = readerService.readLines(path);
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            if (line.trim().isEmpty() || line.startsWith("type")) {
                continue;
            }
            transactions.add(transactionParser.parse(line));
        }
        return transactions;
    }
}
