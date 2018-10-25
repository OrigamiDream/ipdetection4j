package avis.ipqualityscore4j;

import avis.ipqualityscore4j.internal.InternalEmailVerification;
import avis.ipqualityscore4j.internal.InternalProxyDetection;
import avis.ipqualityscore4j.services.EmailVerificationService;
import avis.ipqualityscore4j.services.ProxyDetectionService;

public class IpQualityScore4j {

    private final EmailVerificationService emailVerificationService;
    private final ProxyDetectionService proxyDetectionService;

    public IpQualityScore4j(String privateKey) {
        this.emailVerificationService = new InternalEmailVerification(privateKey);
        this.proxyDetectionService = new InternalProxyDetection(privateKey);
    }

    public EmailVerificationService email() {
        return emailVerificationService;
    }

    public ProxyDetectionService proxy() {
        return proxyDetectionService;
    }
}
