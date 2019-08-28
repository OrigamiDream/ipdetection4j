package avis.ipdetection4j.examples;

import avis.ipdetection4j.iphub4j.IpHub4j;
import avis.ipdetection4j.iphub4j.builders.proxy.ProxyRequestBuilder;

public class IpHub4jTest {

    private static final String API_KEY = "<YOUR API KEY>";

    public static void main(String args[]) {
        IpHub4j ipHub4j = new IpHub4j(API_KEY);
        ipHub4j.proxy().execute(new ProxyRequestBuilder().ip("8.8.8.8")).whenComplete((proxyResponse, throwable) -> {
            System.out.println("IP: " + proxyResponse.ip());
            System.out.println("Country Code: " + proxyResponse.countryCode());
            System.out.println("Country Name: " + proxyResponse.countryName());
            System.out.println("ASN: " + proxyResponse.asn());
            System.out.println("ISP: " + proxyResponse.isp());
            System.out.println("Block: " + proxyResponse.block());
            System.out.println("Hostname: " + proxyResponse.hostname());
        });
    }

}
