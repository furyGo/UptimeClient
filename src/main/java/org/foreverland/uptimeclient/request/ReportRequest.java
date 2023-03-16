package org.foreverland.uptimeclient.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class ReportRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String serverName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String instanceName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String resourceMapJsonStr;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String extra;

    protected ReportRequest(String serverName, String instanceName, String resourceMapJsonStr, String extra) {
        this.serverName = serverName;
        this.instanceName = instanceName;
        this.resourceMapJsonStr = resourceMapJsonStr;
        this.extra = extra;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    public static class ReportRequestBuilder {
        private String serverName;
        private String instanceName;
        private Map<String, ReportMessage> resourceMap = new HashMap<>(0);
        private String extra;

        public static ReportRequestBuilder builder() {
            return new ReportRequestBuilder();
        }

        public ReportRequest.ReportRequestBuilder serverName(String serverName) {
            this.serverName = serverName;
            return this;
        }

        public ReportRequest.ReportRequestBuilder instanceName(String instanceName) {
            this.instanceName = instanceName;
            return this;
        }

        public ReportRequest.ReportRequestBuilder addReport(String resourceName, ReportMessage reportMessage) {
            this.resourceMap.put(resourceName, reportMessage);
            return this;
        }

        public ReportRequest.ReportRequestBuilder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public ReportRequest build() {
            String jsonStr = "";
            try {
                jsonStr = new ObjectMapper().writeValueAsString(this.resourceMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return new ReportRequest(this.serverName, this.instanceName, jsonStr, this.extra);
        }
    }
}
