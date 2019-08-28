package avis.ipdetection4j.iphub4j.internal;

import avis.ipdetection4j.builders.MethodBuilder;
import avis.ipdetection4j.builders.ParameterBuilder;
import avis.ipdetection4j.common.JSONHelper;
import avis.ipdetection4j.internal.proxy.MethodNamedHandler;
import avis.ipdetection4j.iphub4j.proxy.ProxyRequest;
import avis.ipdetection4j.iphub4j.proxy.ProxyResponse;
import avis.ipdetection4j.iphub4j.services.ProxyDetectionService;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class InternalProxyDetection implements ProxyDetectionService, ParameterBuilder, MethodBuilder, JSONHelper {

    private final String privateKey;

    public InternalProxyDetection(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public CompletableFuture<ProxyResponse> execute(ProxyRequest proxyRequest) {
        CompletableFuture<ProxyResponse> future = new CompletableFuture<>();
        newOptionalThread(proxyRequest.sync(), () -> {
            StringBuilder builder = new StringBuilder();
            builder.append("http://v2.api.iphub.info/ip/");
            builder.append(proxyRequest.ip());

            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("X-Key", privateKey);

            JSONObject object = parseJSON(builder.toString(), headerMap);
            ProxyResponse response = proxy(ProxyResponse.class, object, MethodNamedHandler::new);
            future.complete(response);
        });
        return future;
    }
}
