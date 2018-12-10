# IpDetection4j

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
        <groupId>com.github.OrigamiDream.ipdetection4j</groupId>
        <artifactId>bootstrap</artifactId>
        <version>v2.4-SNAPSHOT</version>
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
    implementation 'com.github.OrigamiDream.ipdetection4j:bootstrap:v2.4-SNAPSHOT'
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
