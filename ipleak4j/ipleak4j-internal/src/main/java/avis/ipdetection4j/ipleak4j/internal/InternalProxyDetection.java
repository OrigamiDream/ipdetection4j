package avis.ipdetection4j.ipleak4j.internal;

import avis.ipdetection4j.builders.MethodBuilder;
import avis.ipdetection4j.builders.ParameterBuilder;
import avis.ipdetection4j.common.JSONHelper;
import avis.ipdetection4j.internal.proxy.MethodNamedHandler;
import avis.ipdetection4j.ipleak4j.proxy.ProxyRequest;
import avis.ipdetection4j.ipleak4j.proxy.ProxyResponse;
import avis.ipdetection4j.ipleak4j.services.ProxyDetectionService;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;

public class InternalProxyDetection implements ProxyDetectionService, ParameterBuilder, MethodBuilder, JSONHelper {

    @Override
    public CompletableFuture<ProxyResponse> execute(ProxyRequest proxyRequest) {
        CompletableFuture<ProxyResponse> future = new CompletableFuture<>();
        newOptionalThread(proxyRequest.sync(), () -> {
            StringBuilder builder = new StringBuilder();
            builder.append("https://ipleak.net/json");
            if(proxyRequest.ip() != null) {
                builder.append("/").append(proxyRequest.ip());
            }

            JSONObject object = parseJSON(builder.toString());
            ProxyResponse response = proxy(ProxyResponse.class, object, MethodNamedHandler::new);
            future.complete(response);
        });
        return future;
    }

}
