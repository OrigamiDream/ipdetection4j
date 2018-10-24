package avis.ipqualityscore4j.internal.response;

import avis.ipqualityscore4j.proxy.ProxyResponse;

public class InternalProxyResponse implements ProxyResponse {
    @Override
    public String message() {
        return null;
    }

    @Override
    public boolean success() {
        return false;
    }
}
