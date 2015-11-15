package com.miwa.ws.model;

import com.miwa.model.Service;

public class SubscribedService {
    private String name;
    private String hostname;
    private int port;
    private boolean repeat;

    public SubscribedService(String name, String hostname, int port, boolean repeat) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
        this.repeat = repeat;
    }
    public Service toModel() {
        return new Service(name, hostname, port, repeat);
    }
}
