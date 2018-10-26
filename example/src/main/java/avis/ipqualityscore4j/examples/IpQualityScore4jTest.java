package avis.ipqualityscore4j.examples;

import avis.ipqualityscore4j.IpQualityScore4j;
import avis.ipqualityscore4j.builders.email.EmailRequestBuilder;
import avis.ipqualityscore4j.builders.proxy.ProxyRequestBuilder;

public class IpQualityScore4jTest {

    private static final String API_KEY = "<YOUR API KEY>";

    public static void main(String args[]) {
        IpQualityScore4j ipQualityScore4j = new IpQualityScore4j(API_KEY);
        ipQualityScore4j.proxy().execute(new ProxyRequestBuilder().ipAddress("127.0.0.1")).whenComplete((proxyResponse, throwable) -> {
            System.out.println("Is Proxy: " + proxyResponse.proxy());
            System.out.println("Host: " + proxyResponse.host());
            System.out.println("ISP: " + proxyResponse.isp());
            System.out.println("Organization: " + proxyResponse.organization());
            System.out.println("ASN: " + proxyResponse.asn());
            System.out.println("CountryCode: " + proxyResponse.countryCode());
            System.out.println("City: " + proxyResponse.city());
            System.out.println("Region: " + proxyResponse.region());
            System.out.println("Timezone: " + proxyResponse.timezone());
            System.out.println("Latitude: " + proxyResponse.latitude());
            System.out.println("Longitude: " + proxyResponse.longitude());
            System.out.println("Is Crawler: " + proxyResponse.isCrawler());
            System.out.println("Recent Abuse: " + proxyResponse.recentAbuse());
            System.out.println("VPN: " + proxyResponse.vpn());
            System.out.println("Tor: " + proxyResponse.tor());
            System.out.println("Mobile: " + proxyResponse.mobile());
            System.out.println("Fraud Score: " + proxyResponse.fraudScore());
            System.out.println("Operating System: " + proxyResponse.operatingSystem());
            System.out.println("Browser: " + proxyResponse.browser());
            System.out.println("Device Brand: " + proxyResponse.deviceBrand());
            System.out.println("Device Model: " + proxyResponse.deviceModel());
            System.out.println("Transaction Details: " + proxyResponse.transactionDetails());
            System.out.println("RequestID: " + proxyResponse.requestId());
            System.out.println("Success: " + proxyResponse.success());
            System.out.println("Message: " + proxyResponse.message());
            System.out.println("Errors: " + proxyResponse.errors());
        });

        ipQualityScore4j.email().execute(new EmailRequestBuilder().email("mail@test.com")).whenComplete((emailResponse, throwable) -> {
            System.out.println("Is Valid: " + emailResponse.valid());
            System.out.println("Disposable: " + emailResponse.disposable());
            System.out.println("Timed out: " + emailResponse.timedOut());
            System.out.println("Deliverability: " + emailResponse.deliverability());
            System.out.println("Suspect: " + emailResponse.suspect());
            System.out.println("SMTP score: " + emailResponse.smtpScore());
            System.out.println("Overall score: " + emailResponse.overallScore());
            System.out.println("First Name: " + emailResponse.firstName());
            System.out.println("Is common: " + emailResponse.common());
            System.out.println("Is generic: " + emailResponse.generic());
            System.out.println("Is DNS valid: " + emailResponse.dnsValid());
            System.out.println("Is Honeypot: " + emailResponse.honeypot());
            System.out.println("Is Recent abuse: " + emailResponse.recentAbuse());
            System.out.println("Frequent Complainer: " + emailResponse.frequentComplainer());
            System.out.println("RequestID: " + emailResponse.requestId());
            System.out.println("Success: " + emailResponse.success());
            System.out.println("Message: " + emailResponse.message());
            System.out.println("Errors: " + emailResponse.errors());
        });
    }
}
