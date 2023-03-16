package org.foreverland.uptimeclient;

import com.squareup.okhttp.*;
import lombok.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UptimeClient {
    private String baseUrl = "http://127.0.0.1:8080";
    private Map<String, String> headers = new HashMap<>(0);

    public Response postJson(String path, String requestBody) throws IOException {
        Request.Builder reqBuilder = new Request.Builder();
        reqBuilder.url(baseUrl + path);
        Set<String> headerKeys = headers.keySet();
        for (String key : headerKeys) {
            reqBuilder.addHeader(key, headers.get(key));
        }
        return new OkHttpClient().newCall(
                reqBuilder
                        .post(RequestBody.create(MediaType.parse("application/json"), requestBody)).build()
        ).execute();
    }
}
