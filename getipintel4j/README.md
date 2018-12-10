# GetIpIntel4j

API implementation of [getipintel.net](https://getipintel.net/index.php) in Java.

### Example
A simple example implementation can be found [here](https://github.com/OrigamiDream/ipdetection4j/blob/master/example/src/main/java/avis/ipdetection4j/examples/GetIpIntel4jTest.java).
```java
GetIpIntel4j getIpIntel4j = new GetIpIntel4j();
```

##### Proxy/VPN Detection API Usage
```java
getIpIntel4j.proxy()
        .execute(new ProxyRequestBuilder().ip("127.0.0.1").contact("your@email.com").flags(Flags.B))
        .whenComplete((proxyResponse, throwable) -> {
    System.out.println("Contact: " + proxyResponse.contact());
    System.out.println("Result: " + proxyResponse.result());
    System.out.println("Message: " + proxyResponse.message());
    System.out.println("Status: " + proxyResponse.status());
});
```
You can see detailed usage of the API [here](https://github.com/OrigamiDream/ipdetection4j/blob/master/example/src/main/java/avis/ipdetection4j/examples/GetIpIntel4jTest.java).

[ProxyRequestBuilder](https://github.com/OrigamiDream/ipdetection4j/blob/master/getipintel4j/getipintel4j-builder/src/main/java/avis/ipdetection4j/getipintel4j/builders/proxy/ProxyRequestBuilder.java) supports many API parameters

Refer JavaDoc or official getipintel's API Documentation.