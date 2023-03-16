## UptimeClient

Internal used client

### How to install

add repository to pom.xml

```xml

<repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/furyGo/UptimeClient</url>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```

add dependency

```xml
<dependency>
    <groupId>org.foreverland</groupId>
    <artifactId>uptimeclient</artifactId>
    <version>1.0.0</version>
</dependency>
```

then run `mvn install`

### How to use

```java
class UptimeV2ApiTest {
    
    void report() throws IOException {
        ReportRequest request = ReportRequest.ReportRequestBuilder.builder()
                .serverName("Test-Server")
                .instanceName("Test-Instance")
                .extra("")
                .addReport("disk usage", ReportMessage.getInstance().value("0.95")) // disk usage equals to 95%
                .build();

        UptimeClient uptimeClient = Configuration.getClient("http://127.0.0.1:8080", System.getenv("authorization"));
        Response response = new UptimeV2Api(uptimeClient).report(request);
    }
}
```