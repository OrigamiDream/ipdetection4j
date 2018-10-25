package avis.ipqualityscore4j.examples;

import avis.ipqualityscore4j.IpQualityScore4j;
import avis.ipqualityscore4j.builders.email.EmailRequestBuilder;
import avis.ipqualityscore4j.builders.proxy.ProxyRequestBuilder;

public class IpQualityScore4jTest {

    private static final String API_KEY = "<YOUR API KEY>";

    public static void main(String args[]) {
        IpQualityScore4j ipQualityScore4j = new IpQualityScore4j(API_KEY);
        ipQualityScore4j.proxy().execute(new ProxyRequestBuilder().ipAddress("127.0.0.1")).whenComplete((proxyResponse, throwable) -> {
            System.out.println("Country: " + proxyResponse.countryCode());
            System.out.println("City: " + proxyResponse.city());
        });

        ipQualityScore4j.email().execute(new EmailRequestBuilder().email("mail@test.com")).whenComplete((emailResponse, throwable) -> {
            System.out.println("Deliverability: " + emailResponse.deliverability());
            System.out.println("Is common: " + emailResponse.common());
        });
    }
}
