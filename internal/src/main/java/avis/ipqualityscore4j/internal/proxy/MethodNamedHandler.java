package avis.ipqualityscore4j.internal.proxy;

import avis.ipqualityscore4j.annotations.MethodParser;
import avis.ipqualityscore4j.annotations.Parser;
import avis.ipqualityscore4j.annotations.Uppercase;
import avis.ipqualityscore4j.common.LowcaseBuilder;
import org.json.JSONObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static avis.ipqualityscore4j.common.parsers.ReturnTypeParser.parseReturnType;

public class MethodNamedHandler implements InvocationHandler, LowcaseBuilder {

    private static final Map<String, String> METHOD_CACHE = new HashMap<>();
    private final JSONObject data;

    public MethodNamedHandler(JSONObject data) {
        this.data = data;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = null;
        try {
            Uppercase uppercase = method.getAnnotation(Uppercase.class);
            MethodParser methodParser = method.getAnnotation(MethodParser.class);

            String key = fromCache(method.getName());
            if(uppercase != null) {
                key = key.toUpperCase();
            }
            Class<?> returnType = method.getReturnType();
            value = parseReturnType(returnType, method, key, data);
            if(methodParser != null) {
                Class<? extends Parser> clazz = methodParser.value();
                Parser parser = clazz.getConstructor().newInstance();
                value = parser.parse(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

}
