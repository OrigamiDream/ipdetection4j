package avis.ipdetection4j.common;

import org.json.JSONObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.function.Function;

public interface ProxyHelper<R> {

    default R proxy(Class[] interfaces, JSONObject data, Function<JSONObject, InvocationHandler> function) {
        return (R) Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, function.apply(data));
    }

}
