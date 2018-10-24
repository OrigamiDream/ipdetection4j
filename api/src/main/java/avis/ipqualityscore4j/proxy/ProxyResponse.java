package avis.ipqualityscore4j.proxy;

import avis.ipqualityscore4j.components.Response;

import java.util.List;

public interface ProxyResponse extends Response {

    boolean proxy();

    String host();

    String isp();

    String organization();

    String asn();

    String countryCode();

    String city();

    String region();

    String timezone();

    String latitude();

    String longitude();

    boolean isCrawler();

    boolean recentAbuse();

    boolean vpn();

    boolean tor();

    boolean mobile();

    float fraudScore();

    String operatingSystem();

    String browser();

    String deviceBrand();

    String deviceModel();

    Object transactionDetails();

}
