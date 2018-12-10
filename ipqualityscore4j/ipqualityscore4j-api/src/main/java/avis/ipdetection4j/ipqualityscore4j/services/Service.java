package avis.ipdetection4j.ipqualityscore4j.services;

import avis.ipdetection4j.common.ProxyHelper;
import avis.ipdetection4j.ipqualityscore4j.components.Request;
import avis.ipdetection4j.ipqualityscore4j.components.Response;
import org.json.JSONObject;

import java.lang.reflect.InvocationHandler;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface Service<R extends Response, Q extends Request> extends ProxyHelper<R> {

    CompletableFuture<R> execute(Q q);

    default R proxy(Class<R> responseType, JSONObject data, Function<JSONObject, InvocationHandler> function) {
        return proxy(new Class[] { responseType, Response.class }, data, function);
    }

    default void newOptionalThread(boolean sync, Runnable runnable) {
        if(sync) {
            runnable.run();
        } else {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
