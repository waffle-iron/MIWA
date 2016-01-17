package com.miwa.ws.pojo;

import com.miwa.model.Domain.Service;

public class SubscribedServicePOJO {
    private String name;
    private String hostname;
    private int port;
    private boolean repeat;

    public SubscribedServicePOJO(String name, String hostname, int port, boolean repeat) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
        this.repeat = repeat;
    }
    public Service toModel() {
        return new Service(name, hostname, port, repeat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }
}
