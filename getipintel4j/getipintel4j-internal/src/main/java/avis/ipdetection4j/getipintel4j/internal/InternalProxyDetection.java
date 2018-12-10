package avis.ipdetection4j.getipintel4j.internal;

import avis.ipdetection4j.builders.IParameter;
import avis.ipdetection4j.builders.MethodBuilder;
import avis.ipdetection4j.builders.ParameterBuilder;
import avis.ipdetection4j.common.JSONHelper;
import avis.ipdetection4j.getipintel4j.proxy.ProxyRequest;
import avis.ipdetection4j.getipintel4j.proxy.ProxyResponse;
import avis.ipdetection4j.getipintel4j.services.ProxyDetectionService;
import avis.ipdetection4j.internal.proxy.MethodNamedHandler;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;

public class InternalProxyDetection implements ProxyDetectionService, ParameterBuilder, MethodBuilder, JSONHelper {

    @Override
    public CompletableFuture<ProxyResponse> execute(ProxyRequest proxyRequest) {
        CompletableFuture<ProxyResponse> future = new CompletableFuture<>();
        newOptionalThread(proxyRequest.sync(), () -> {
            String parameters;
            if(proxyRequest instanceof IParameter) {
                parameters = buildByParameter(proxyRequest);
            } else {
                parameters = buildByMethod(proxyRequest);
            }
            StringBuilder builder = new StringBuilder();
            builder.append("http://check.getipintel.net/check.php?format=json");
            if(parameters.length() > 0) {
                builder.append("&");
                builder.append(parameters);
            }
            JSONObject object = parseJSON(builder.toString());
            ProxyResponse response = proxy(ProxyResponse.class, object, MethodNamedHandler::new);
            future.complete(response);
        });
        return future;
    }
}
