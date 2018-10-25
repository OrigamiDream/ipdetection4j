# IpQualityScore4j

API implementation of [ipqualityscore.com](https://ipqualityscore4j.com) in Java.

### Compile
for OS X/Linux:
```
./mvnw clean install
```

for Windows:
```
mvnw.cmd clean install
```

### Example
A simple example implementation can be found [here](https://github.com/OrigamiDream/ipqualityscore4j/blob/master/example/src/main/java/avis/ipqualityscore4j/examples/IpQualityScore4jTest.java).
```java
IpQualityScore4j ipQualityScore4j = new IpQualityScore4j("<YOUR API HERE>");
```
You can get your own API key from the website.

##### Proxy/VPN Detection API Usage
```java
ipQualityScore4j.proxy()
        .execute(new ProxyRequestBuilder().ipAddress("127.0.0.1"))
        .whenComplete((proxyResponse, throwable) -> {
            
    System.out.println("Country: " + proxyResponse.countryCode());
    System.out.println("City: " + proxyResponse.city());
});
```

##### Email Verification API Usage
```java
ipQualityScore4j.email()
        .execute(new EmailRequestBuilder().email("mail@test.com"))
        .whenComplete((emailResponse, throwable) -> {
            
    System.out.println("Deliverability: " + emailResponse.deliverability());
    System.out.println("Is common: " + emailResponse.common());
});
```


[EmailRequestBuilder](https://github.com/OrigamiDream/ipqualityscore4j/blob/master/builder/src/main/java/avis/ipqualityscore4j/builders/email/EmailRequestBuilder.java) and [ProxyRequestBuilder](https://github.com/OrigamiDream/ipqualityscore4j/blob/master/builder/src/main/java/avis/ipqualityscore4j/builders/proxy/ProxyRequestBuilder.java) supports many API parameters

Refer JavaDoc or official ipqualityscore's API Documentation.


### TODO

 -[ ] Postback request of Email Verification API