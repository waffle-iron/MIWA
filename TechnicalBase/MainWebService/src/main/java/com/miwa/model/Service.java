package com.miwa.model;


import java.io.Serializable;

public class Service implements Serializable {
    private Integer serviceid;
    private String name;
    private String hostname;
    private Integer port;
    private Boolean repeat;

    public Service() {
    }

    public Service(String name, String hostname, Integer port, Boolean repeat) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
        this.repeat = repeat;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getRepeat() {
        return repeat;
    }

    public void setRepeat(Boolean repeat) {
        this.repeat = repeat;
    }
}
