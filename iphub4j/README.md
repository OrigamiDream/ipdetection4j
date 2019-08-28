# IpHub4j

API implementation of [iphub.info](https://iphub.info) in Java.

### Example
A simple example implementation can be found [here](https://github.com/OrigamiDream/ipdetection4j/blob/master/example/src/main/java/avis/ipdetection4j/examples/IpHub4jTest.java).
```java
IpHub4j ipHub4j = new IpHub4j("<YOUR API HERE>");
```
You can get your own API key from the website.

##### Proxy/VPN Detection API Usage
```java
ipHub4j.proxy()
        .execute(new ProxyRequestBuilder().ip("8.8.8.8"))
        .whenComplete((proxyResponse, throwable) -> {

    System.out.println("IP: " + proxyResponse.ip());
    System.out.println("Country Code: " + proxyResponse.countryCode());
    System.out.println("Country Name: " + proxyResponse.countryName());
    System.out.println("ASN: " + proxyResponse.asn());
    System.out.println("ISP: " + proxyResponse.isp());
    System.out.println("Block: " + proxyResponse.block());
    System.out.println("Hostname: " + proxyResponse.hostname());
});
```

You can see detailed usage of the API [here](https://github.com/OrigamiDream/ipdetection4j/blob/master/example/src/main/java/avis/ipdetection4j/examples/IpHub4jTest.java).

Refer official IpHub's API Documentation.