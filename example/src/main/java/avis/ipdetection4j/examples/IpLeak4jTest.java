package avis.ipdetection4j.examples;

import avis.ipdetection4j.ipleak4j.IpLeak4j;
import avis.ipdetection4j.ipleak4j.builders.proxy.ProxyRequestBuilder;

public class IpLeak4jTest {

    public static void main(String[] args) {
        IpLeak4j ipLeak4j = new IpLeak4j();
        ipLeak4j.proxy().execute(new ProxyRequestBuilder().ip("8.8.8.8")).whenComplete((proxyResponse, throwable) -> {
            System.out.println("Country Code: " + proxyResponse.countryCode());
            System.out.println("Country Name: " + proxyResponse.countryName());
            System.out.println("Region Code: " + proxyResponse.regionCode());
            System.out.println("Region Name: " + proxyResponse.regionName());
            System.out.println("City Name: " + proxyResponse.cityName());
            System.out.println("Latitude: " + proxyResponse.latitude());
            System.out.println("Longitude: " + proxyResponse.longitude());
            System.out.println("Metro Code: " + proxyResponse.metroCode());
            System.out.println("Area Code: " + proxyResponse.areaCode());
            System.out.println("Time Zone: " + proxyResponse.timeZone());
            System.out.println("Continent Code: " + proxyResponse.continentCode());
            System.out.println("Postal Code: " + proxyResponse.postalCode());
            System.out.println("ISP Name: " + proxyResponse.ispName());
            System.out.println("Organization Name: " + proxyResponse.organizationName());
            System.out.println("As Number: " + proxyResponse.asNumber());
            System.out.println("Networking Speed: " + proxyResponse.netspeed());
            System.out.println("User Type: " + proxyResponse.userType());
            System.out.println("Accuracy Radius: " + proxyResponse.accuracyRadius());
            System.out.println("Country Confidence: " + proxyResponse.countryConfidence());
            System.out.println("City Confidence: " + proxyResponse.cityConfidence());
            System.out.println("Region Confidence: " + proxyResponse.regionConfidence());
            System.out.println("Postal Confidence: " + proxyResponse.postalConfidence());
            System.out.println("Level: " + proxyResponse.level());
            System.out.println("Cache: " + proxyResponse.cache());
            System.out.println("Continent Name: " + proxyResponse.continentName());
            System.out.println("IP: " + proxyResponse.ip());
            System.out.println("Type: " + proxyResponse.type());
            System.out.println("Reverse: " + proxyResponse.reverse());
            System.out.println("Tor: " + proxyResponse.tor());
            System.out.println("Query Text: " + proxyResponse.queryText());
            System.out.println("Query Type: " + proxyResponse.queryType());
            System.out.println("Query Date: " + proxyResponse.queryDate());
        });
    }

}
