package org.foreverland.uptimeclient.api;

import com.squareup.okhttp.Response;
import org.foreverland.uptimeclient.Configuration;
import org.foreverland.uptimeclient.UptimeClient;
import org.foreverland.uptimeclient.request.ReportRequest;

import java.io.IOException;

public class UptimeV2Api {

    private static final String basePath = "/uptime/v2";
    private static final String reportPath = basePath + "/report";

    private UptimeClient client = Configuration.getDefaultClient();

    public UptimeV2Api() {}

    public UptimeV2Api(UptimeClient client) {
        this.client = client;
    }

    public Response report(ReportRequest request) throws IOException {
        return client.postJson(reportPath, request.toJson());
    }
}
