package com.miwa.ws.pojo;

public class CallbackPOJO {
    private String cron;
    private String message;
    private String endpoint;
    private String service_name;
    private String request_type;

    public CallbackPOJO(String cron, String message, String endpoint, String request_type) {
        this.cron = cron;
        this.message = message;
        this.endpoint = endpoint;
        this.request_type = request_type;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    @Override
    public String toString() {
        return "CallbackPOJO{" +
                "cron='" + cron + '\'' +
                ", message='" + message + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", service_name='" + service_name + '\'' +
                ", request_type='" + request_type + '\'' +
                '}';
    }
}
