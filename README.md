# IpDetection4j

### Gradle/Maven
##### Maven
```xml
<repositories>
    <repository>
        <id>ipdetection4j</id>
        <url>https://maven.pkg.github.com/OrigamiDream</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>studio.avis.ipdetection4j</groupId>
        <artifactId>bootstrap</artifactId>
        <version>2.10.0</version>
    </dependency>
</dependencies>
```
##### Gradle
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://maven.pkg.github.com/OrigamiDream' }
    }
}

dependencies {
    implementation 'studio.avis.ipdetection4j:bootstrap:v2.10.0'
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
