package avis.ipqualityscore4j.internal;

import avis.ipqualityscore4j.email.EmailRequest;
import avis.ipqualityscore4j.email.EmailResponse;
import avis.ipqualityscore4j.services.EmailVerificationService;

import java.util.concurrent.Future;

public class InternalEmailVerification implements EmailVerificationService {

    @Override
    public Future<EmailResponse> execute(EmailRequest emailRequest) {
        return null;
    }

}
