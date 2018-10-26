package avis.ipqualityscore4j.builders.proxy;

import avis.ipqualityscore4j.builders.IParameter;
import avis.ipqualityscore4j.builders.Parameter;
import avis.ipqualityscore4j.proxy.ProxyRequest;

public class ProxyRequestBuilder implements ProxyRequest, IParameter {

    private String ipAddress;
    private boolean sync;
    
    private final Parameter parameter = new Parameter();

    public ProxyRequestBuilder ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    @Override
    public String ipAddress() {
        return ipAddress;
    }

    public ProxyRequestBuilder strictness(int strictness) {
        parameter.put("strictness", strictness);
        return this;
    }

    @Override
    public int strictness() {
        return parameter.get("strictness");
    }

    public ProxyRequestBuilder userAgent(String userAgent) {
        parameter.put("user_agent", userAgent);
        return this;
    }

    @Override
    public String userAgent() {
        return parameter.get("user_agent");
    }

    public ProxyRequestBuilder userLanguage(String userLanguage) {
        parameter.put("user_language", userLanguage);
        return this;
    }

    @Override
    public String userLanguage() {
        return parameter.get("user_language");
    }

    public ProxyRequestBuilder fast(boolean fast) {
        parameter.put("fast", fast);
        return this;
    }

    @Override
    public boolean fast() {
        return parameter.get("fast");
    }

    public ProxyRequestBuilder mobile(boolean mobile) {
        parameter.put("mobile", mobile);
        return this;
    }

    @Override
    public boolean mobile() {
        return parameter.get("mobile");
    }

    public ProxyRequestBuilder allowPublicAccessPoints(boolean allowPublicAccessPoints) {
        parameter.put("allow_public_access_points", allowPublicAccessPoints);
        return this;
    }

    @Override
    public boolean allowPublicAccessPoints() {
        return parameter.get("allow_public_access_points");
    }

    public ProxyRequestBuilder transactionStrictness(int transactionStrictness) {
        parameter.put("transaction_strictness", transactionStrictness);
        return this;
    }

    @Override
    public int transactionStrictness() {
        return parameter.get("transaction_strictness");
    }

    @Override
    public Parameter getParameter() {
        return parameter;
    }
    
    public ProxyRequestBuilder sync(boolean sync) {
        this.sync = sync;
        return this;
    }
    
    @Override
    public boolean sync() {
        return sync;
    }
}
