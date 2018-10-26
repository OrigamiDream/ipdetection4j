# IpQualityScore4j

API implementation of [ipqualityscore.com](https://ipqualityscore.com/) in Java.

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
You can see detailed usage of the API [here](https://github.com/OrigamiDream/ipqualityscore4j/blob/master/example/src/main/java/avis/ipqualityscore4j/examples/IpQualityScore4jTest.java).

[EmailRequestBuilder](https://github.com/OrigamiDream/ipqualityscore4j/blob/master/builder/src/main/java/avis/ipqualityscore4j/builders/email/EmailRequestBuilder.java) and [ProxyRequestBuilder](https://github.com/OrigamiDream/ipqualityscore4j/blob/master/builder/src/main/java/avis/ipqualityscore4j/builders/proxy/ProxyRequestBuilder.java) supports many API parameters

Refer JavaDoc or official ipqualityscore's API Documentation.

### Gradle/Maven
##### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.OrigamiDream</groupId>
        <artifactId>ipqualityscore4j</artifactId>
        <version>v1.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```
##### Gradle
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.OrigamiDream:ipqualityscore4j:v1.1-SNAPSHOT'
}
```


### Compile
for OS X/Linux:
```
./mvnw clean install
```

for Windows:
```
mvnw.cmd clean install
```


### TODO

 - [ ] Postback request of Email Verification API
