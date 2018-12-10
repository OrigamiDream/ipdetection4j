package avis.ipdetection4j.examples;

import avis.ipdetection4j.getipintel4j.GetIpIntel4j;
import avis.ipdetection4j.getipintel4j.builders.proxy.ProxyRequestBuilder;
import avis.ipdetection4j.getipintel4j.components.Flags;

public class GetIpIntel4jTest {

    public static void main(String args[]) {
        GetIpIntel4j getIpIntel4j = new GetIpIntel4j();
        getIpIntel4j.proxy()
                .execute(new ProxyRequestBuilder().ip("127.0.0.1").contact("your@email.com").flags(Flags.B))
                .whenComplete((proxyResponse, throwable) -> {
            System.out.println("Contact: " + proxyResponse.contact());
            System.out.println("Result: " + proxyResponse.result());
            System.out.println("Message: " + proxyResponse.message());
            System.out.println("Status: " + proxyResponse.status());
            System.out.println("Query Flags: " + proxyResponse.queryFlags());
            System.out.println("Query O Flags: " + proxyResponse.queryOFlags());
            System.out.println("Query IP: " + proxyResponse.queryIP());
            System.out.println("Query Format: " + proxyResponse.queryFormat());
        });
    }

}
