package avis.ipdetection4j.ipqualityscore4j.internal;

import avis.ipdetection4j.builders.IParameter;
import avis.ipdetection4j.builders.MethodBuilder;
import avis.ipdetection4j.builders.ParameterBuilder;
import avis.ipdetection4j.common.JSONHelper;
import avis.ipdetection4j.internal.proxy.MethodNamedHandler;
import avis.ipdetection4j.ipqualityscore4j.proxy.ProxyRequest;
import avis.ipdetection4j.ipqualityscore4j.proxy.ProxyResponse;
import avis.ipdetection4j.ipqualityscore4j.services.ProxyDetectionService;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;

public class InternalProxyDetection extends InternalService implements ProxyDetectionService, ParameterBuilder, MethodBuilder, JSONHelper {

    public InternalProxyDetection(String privateKey) {
        super(privateKey);
    }

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
            builder.append("https://www.ipqualityscore.com/api/json/ip/");
            builder.append(getPrivateKey());
            builder.append("/");
            builder.append(proxyRequest.ipAddress());
            if(parameters.length() > 0) {
                builder.append("?");
                builder.append(parameters);
            }
            JSONObject object = parseJSON(builder.toString());
            ProxyResponse response = proxy(ProxyResponse.class, object, MethodNamedHandler::new);
            future.complete(response);
        });
        return future;
    }
}
