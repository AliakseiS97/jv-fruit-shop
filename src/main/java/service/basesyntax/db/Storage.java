package service.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public Map<String, Integer> getStorage() {
        return Collections.unmodifiableMap(storage);
    }
}
