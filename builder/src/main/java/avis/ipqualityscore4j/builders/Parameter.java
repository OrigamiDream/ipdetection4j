package avis.ipqualityscore4j.builders;

import java.util.HashMap;
import java.util.Map;

public class Parameter {

    private final Map<String, Object> parameters = new HashMap<>();

    public void put(String key, Object value) {
        parameters.put(key, value);
    }

    public <T> T get(String key) {
        return (T) parameters.get(key);
    }

    public <T> T get(String key, Class<T> type) {
        return get(key);
    }

}
