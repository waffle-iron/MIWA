package com.miwa.model;

public class Callback {
    private Integer callbackid;
    private String cron;
    private String message;
    private String endpoint;
    private Service service;
    private String requestType;

    public Callback() {
    }

    public Callback(String cron, String message, String endpoint, Service service, String requestType) {
        this.cron = cron;
        this.message = message;
        this.endpoint = endpoint;
        this.service = service;
        this.requestType = requestType;
    }

    public Integer getCallbackid() {
        return callbackid;
    }

    public void setCallbackid(Integer callbackid) {
        this.callbackid = callbackid;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

}
