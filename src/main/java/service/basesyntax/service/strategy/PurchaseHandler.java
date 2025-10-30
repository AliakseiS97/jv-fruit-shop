package service.basesyntax.service.strategy;

import java.util.Map;
import service.basesyntax.db.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        if (storage == null) {
            throw new NullPointerException("storage is null");
        }
        if (transaction == null) {
            throw new NullPointerException("transaction is null");
        }
        int newQuantity = storage.getOrDefault(transaction.getFruit(),
                0) - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new ArithmeticException("Not enough "
                    + transaction.getFruit()
                    + "in the store."
                    + " Available: "
                    + storage.getOrDefault(transaction.getFruit(), 0)
                    + ", requested: "
                    + transaction.getQuantity());
        }
        storage.put(transaction.getFruit(), newQuantity);
    }
}
