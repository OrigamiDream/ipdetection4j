package avis.ipdetection4j.ipleak4j.builders.proxy;

import avis.ipdetection4j.ipleak4j.proxy.ProxyRequest;

public class ProxyRequestBuilder implements ProxyRequest {

    private String ip;
    private boolean sync;

    @Override
    public String ip() {
        return ip;
    }

    public ProxyRequestBuilder ip(String ip) {
        this.ip = ip;
        return this;
    }

    @Override
    public boolean sync() {
        return sync;
    }

    public ProxyRequestBuilder sync(boolean sync) {
        this.sync = sync;
        return this;
    }
}
