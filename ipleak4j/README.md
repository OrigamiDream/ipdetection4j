# IpLeak4j

API implementation of [ipleak.net](https://ipleak.net) in Java.

### Example
A simple example implementation can be found [here](https://github.com/OrigamiDream/ipdetection4j/blob/master/example/src/main/java/avis/ipdetection4j/examples/IpLeak4jTest.java).
```java
IpLeak4j ipLeak4j = new IpLeak4j();
```
You can get your own API key from the website.

##### Proxy/VPN Detection API Usage
```java
ipLeak4j.proxy()
        .execute(new ProxyRequestBuilder().ip("8.8.8.8"))
        .whenComplete((proxyResponse, throwable) -> {

    System.out.println("Country Code: " + proxyResponse.countryCode());
    System.out.println("Country Name: " + proxyResponse.countryName());
    System.out.println("Region Code: " + proxyResponse.regionCode());
    System.out.println("Region Name: " + proxyResponse.regionName());
    System.out.println("City Name: " + proxyResponse.cityName());
    System.out.println("Latitude: " + proxyResponse.latitude());
    System.out.println("Longitude: " + proxyResponse.longitude());
    System.out.println("Query Text: " + proxyResponse.queryText());
    System.out.println("Query Type: " + proxyResponse.queryType());
    System.out.println("Query Date: " + proxyResponse.queryDate());
});
```

You can see detailed usage of the API [here](https://github.com/OrigamiDream/ipdetection4j/blob/master/example/src/main/java/avis/ipdetection4j/examples/IpLeak4jTest.java).

Refer official IpLeak(AirVPN)'s API Documentation.