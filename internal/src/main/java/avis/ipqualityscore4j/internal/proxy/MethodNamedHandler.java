package avis.ipqualityscore4j.internal.proxy;

import avis.ipqualityscore4j.annotations.MethodParser;
import avis.ipqualityscore4j.annotations.Parser;
import avis.ipqualityscore4j.annotations.Uppercase;
import avis.ipqualityscore4j.common.LowcaseBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MethodNamedHandler implements InvocationHandler, LowcaseBuilder {

    private static final Map<String, String> METHOD_CACHE = new HashMap<>();
    private final JSONObject data;

    public MethodNamedHandler(JSONObject data) {
        this.data = data;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Uppercase uppercase = method.getAnnotation(Uppercase.class);
        MethodParser methodParser = method.getAnnotation(MethodParser.class);

        String key = fromCache(method.getName());
        if(uppercase != null) {
            key = key.toUpperCase();
        }
        Class<?> returnType = method.getReturnType();
        Object value = parseReturnType(returnType, key);
        if(methodParser != null) {
            Class<? extends Parser> clazz = methodParser.value();
            Parser parser = clazz.getConstructor().newInstance();
            value = parser.parse(value);
        }
        return value;
    }

    private String fromCache(String methodName) {
        String key;
        if(!METHOD_CACHE.containsKey(methodName)) {
            key = makeLowcase(methodName);
            METHOD_CACHE.put(methodName, key);
        } else {
            key = METHOD_CACHE.get(methodName);
        }
        return key;
    }

    private Object parseReturnType(Class<?> returnType, String key) {
        if(returnType == Integer.class || returnType == int.class) {
            return data.has(key) ? data.getInt(key) : 0;
        } else if(returnType == Double.class || returnType == double.class) {
            return data.has(key) ? data.getDouble(key) : 0d;
        } else if(returnType == Long.class || returnType == long.class) {
            return data.has(key) ? data.getLong(key) : 0;
        } else if(returnType == Boolean.class || returnType == boolean.class) {
            return data.has(key) && data.getBoolean(key);
        } else if(returnType == Float.class || returnType == float.class) {
            return data.has(key) ? data.getFloat(key) : 0f;
        } else if(returnType == BigDecimal.class) {
            return data.has(key) ? data.getBigDecimal(key) : BigDecimal.ZERO;
        } else if(returnType == BigInteger.class) {
            return data.has(key) ? data.getBigInteger(key) : BigInteger.ZERO;
        } else if(returnType == JSONObject.class) {
            return data.has(key) ? data.getJSONObject(key) : new JSONObject();
        } else if(returnType == JSONArray.class) {
            return data.has(key) ? data.getJSONArray(key) : new JSONArray();
        } else {
            return data.has(key) ? data.get(key) : null;
        }
    }

}
