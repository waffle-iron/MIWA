package com.miwa.model.Domain;

import javax.persistence.*;

@Entity
public class Callback {
    @Id
    @GeneratedValue
    private Integer callbackid;
    @Column(nullable = false)
    private String cron;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private String endpoint;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "serviceid", nullable = false)
    private Service service;
    @Column(nullable = false)
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
