package service.basesyntax.service;

import java.util.List;
import service.basesyntax.db.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
