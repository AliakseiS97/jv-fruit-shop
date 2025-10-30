package service.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import service.basesyntax.db.FruitTransaction;

public class TransactionParserService {
    private final TransactionParser transactionParser;

    public TransactionParserService(TransactionParser transactionParser) {
        this.transactionParser = transactionParser;
    }

    public List<FruitTransaction> parseTransactions(List<String> lines) {
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
