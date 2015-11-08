package com.miwa.ws.model;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

public class Callback {
    private String cron;
    private String message;
    private String endpoint;


    public Callback(String cron, String message, String endpoint) {
        this.cron = cron;
        this.message = message;
        this.endpoint = endpoint;
    }

}
