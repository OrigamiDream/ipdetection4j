package avis.ipqualityscore4j.internal;

import avis.ipqualityscore4j.builders.IParameter;
import avis.ipqualityscore4j.builders.MethodBuilder;
import avis.ipqualityscore4j.builders.ParameterBuilder;
import avis.ipqualityscore4j.common.JSONHelper;
import avis.ipqualityscore4j.email.EmailRequest;
import avis.ipqualityscore4j.email.EmailResponse;
import avis.ipqualityscore4j.internal.proxy.MethodNamedHandler;
import avis.ipqualityscore4j.services.EmailVerificationService;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;

public class InternalEmailVerification extends InternalService implements EmailVerificationService, ParameterBuilder, MethodBuilder, JSONHelper {

    public InternalEmailVerification(String privateKey) {
        super(privateKey);
    }

    @Override
    public CompletableFuture<EmailResponse> execute(EmailRequest emailRequest) {
        CompletableFuture<EmailResponse> future = new CompletableFuture<>();
        newOptionalThread(emailRequest.sync(), () -> {
            String parameters;
            if(emailRequest instanceof IParameter) {
                parameters = buildByParameter(emailRequest);
            } else {
                parameters = buildByMethod(emailRequest);
            }
            StringBuilder builder = new StringBuilder();
            builder.append("https://www.ipqualityscore.com/api/json/email/");
            builder.append(getPrivateKey());
            builder.append("/");
            builder.append(emailRequest.email());
            if(parameters.length() > 0) {
                builder.append("?");
                builder.append(parameters);
            }
            JSONObject object = parseJSON(builder.toString());
            EmailResponse response = proxy(EmailResponse.class, object, MethodNamedHandler::new);
            future.complete(response);
        });
        return future;
    }
}
