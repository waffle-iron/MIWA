package com.miwa.ws.pojo;

public class CallbackPOJO {
    private String cron;
    private String message;
    private String endpoint;
    private String service_name;

    public CallbackPOJO(String cron, String message, String endpoint) {
        this.cron = cron;
        this.message = message;
        this.endpoint = endpoint;
    }

    public String getService_name() {
        return service_name;
    }

    public String getCron() {
        return cron;
    }

    public String getMessage() {
        return message;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}
