package com.miwa.ws.model;

public class SubscribedService {
    private String name;
    private String hostname;
    private int port;

    public SubscribedService(String name, String hostname, int port) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
    }
}
