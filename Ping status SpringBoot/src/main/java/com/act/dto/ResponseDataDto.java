package com.act.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseDataDto {
    private String byteSent;
    private String responseTime;
    private String statusCategory;

    public ResponseDataDto(String byteSent, String responseTime, String statusCategory) {
        this.byteSent = byteSent;
        this.responseTime = responseTime;
        this.statusCategory = statusCategory;
    }

    public ResponseDataDto() {
    }

    public String getByteSent() {
        return byteSent;
    }

    public void setByteSent(String byteSent) {
        this.byteSent = byteSent;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(String statusCategory) {
        this.statusCategory = statusCategory;
    }
}
