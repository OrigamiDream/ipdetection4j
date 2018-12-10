package avis.ipdetection4j.ipqualityscore4j.internal;

public abstract class InternalService {

    private final String privateKey;

    protected InternalService(String privateKey) {
        this.privateKey = privateKey;
    }

    protected String getPrivateKey() {
        return privateKey;
    }
}
