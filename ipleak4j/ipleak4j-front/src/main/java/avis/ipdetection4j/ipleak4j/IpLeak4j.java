package avis.ipdetection4j.ipleak4j;

import avis.ipdetection4j.ipleak4j.internal.InternalProxyDetection;
import avis.ipdetection4j.ipleak4j.services.ProxyDetectionService;

public class IpLeak4j {

    private final ProxyDetectionService proxyDetectionService;

    public IpLeak4j() {
        this.proxyDetectionService = new InternalProxyDetection();
    }

    public ProxyDetectionService proxy() {
        return proxyDetectionService;
    }

}
