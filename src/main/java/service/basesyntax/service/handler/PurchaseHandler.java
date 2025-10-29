package service.basesyntax.service.handler;

import service.basesyntax.model.FruitTransaction;

import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        int newQuantity = storage.getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new ArithmeticException("Not enough " + transaction.getFruit()
                    + "in the store." + " Available: " + storage.getOrDefault(transaction.getFruit(), 0)
                    + ", requested: " + transaction.getQuantity());
        }
        storage.put(transaction.getFruit(), newQuantity);
    }
}
