package avis.ipdetection4j.iphub4j;

import avis.ipdetection4j.iphub4j.internal.InternalProxyDetection;
import avis.ipdetection4j.iphub4j.services.ProxyDetectionService;

public class IpHub4j {

    private final ProxyDetectionService proxyDetectionService;

    public IpHub4j(String privateKey) {
        this.proxyDetectionService = new InternalProxyDetection(privateKey);
    }

    public ProxyDetectionService proxy() {
        return proxyDetectionService;
    }
}
