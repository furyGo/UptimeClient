package org.foreverland.uptimeclient.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReportMessage {

    private String value = "";
    private List<ReportMessageKV> values = new ArrayList<>(0);

    public static ReportMessage getInstance() {
        return new ReportMessage();
    }

    public ReportMessage value(String value) {
        this.value = value;
        return this;
    }

    public ReportMessage put(String name, String value) {
        this.values.add(new ReportMessageKV(name, value));
        return this;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    private static class ReportMessageKV {
        private String name;
        private String value;
    }
}

