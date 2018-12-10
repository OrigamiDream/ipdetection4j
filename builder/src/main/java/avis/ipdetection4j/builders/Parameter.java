package avis.ipdetection4j.builders;

import java.util.LinkedHashMap;

public class Parameter {

    private final LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

    public void put(String key, Object value) {
        parameters.put(key, value);
    }

    public <T> T get(String key) {
        return (T) parameters.get(key);
    }

    public <T> T get(String key, Class<T> type) {
        return get(key);
    }

    LinkedHashMap<String, Object> getParameters() {
        return parameters;
    }
}
