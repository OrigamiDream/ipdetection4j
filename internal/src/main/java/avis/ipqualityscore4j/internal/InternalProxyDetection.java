package avis.ipqualityscore4j.internal;

import avis.ipqualityscore4j.proxy.ProxyRequest;
import avis.ipqualityscore4j.proxy.ProxyResponse;
import avis.ipqualityscore4j.services.ProxyDetectionService;

import java.util.concurrent.Future;

public class InternalProxyDetection implements ProxyDetectionService {

    @Override
    public Future<ProxyResponse> execute(ProxyRequest proxyRequest) {
        return null;
    }

}
