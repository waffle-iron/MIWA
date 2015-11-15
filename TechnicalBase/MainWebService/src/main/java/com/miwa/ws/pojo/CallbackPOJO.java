package com.miwa.ws.pojo;

public class CallbackPOJO {
    private String cron;
    private String message;
    private String endpoint;


    public CallbackPOJO(String cron, String message, String endpoint) {
        this.cron = cron;
        this.message = message;
        this.endpoint = endpoint;
    }

}
