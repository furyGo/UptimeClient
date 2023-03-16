package org.foreverland.uptimeclient;

import java.util.Map;

public class Configuration {

    public static UptimeClient getDefaultClient() {
        return new UptimeClient();
    }

    public static UptimeClient getLocalClient(String auth) {
        UptimeClient uptimeClient = getDefaultClient();
        uptimeClient.getHeaders().put("authorization", auth);
        return uptimeClient;
    }

    public static UptimeClient getClient(String baseUrl, Map<String, String> headers) {
        return new UptimeClient(baseUrl, headers);
    }

    public static UptimeClient getClient(String baseUrl, String auth) {
        UptimeClient uptimeClient = getDefaultClient();
        uptimeClient.setBaseUrl(baseUrl);
        uptimeClient.getHeaders().put("authorization", auth);
        return uptimeClient;
    }
}
