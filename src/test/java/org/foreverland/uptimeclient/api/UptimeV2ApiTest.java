package org.foreverland.uptimeclient.api;

import com.squareup.okhttp.Response;
import org.foreverland.uptimeclient.Configuration;
import org.foreverland.uptimeclient.UptimeClient;
import org.foreverland.uptimeclient.request.ReportMessage;
import org.foreverland.uptimeclient.request.ReportRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class UptimeV2ApiTest {

    @Test
    void report() throws IOException {
        ReportRequest request = ReportRequest.ReportRequestBuilder.builder()
                .serverName("Test-Server")
                .instanceName("Test-Instance")
                .extra("")
                .addReport("disk usage", ReportMessage.getInstance().value("0.95"))
                .build();

        UptimeClient uptimeClient = Configuration.getClient("http://127.0.0.1:8080", System.getenv("authorization"));
        Response response = new UptimeV2Api(uptimeClient).report(request);
        System.out.println(response);
    }
}