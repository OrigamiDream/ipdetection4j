package avis.ipdetection4j.getipintel4j;

import avis.ipdetection4j.getipintel4j.internal.InternalProxyDetection;
import avis.ipdetection4j.getipintel4j.services.ProxyDetectionService;

public class GetIpIntel4j {

    private final ProxyDetectionService proxyDetectionService;

    public GetIpIntel4j() {
        this.proxyDetectionService = new InternalProxyDetection();
    }

    public ProxyDetectionService proxy() {
        return proxyDetectionService;
    }
}
