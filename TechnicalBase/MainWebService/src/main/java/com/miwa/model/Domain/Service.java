package com.miwa.model.Domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private Integer serviceid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hostname;

    @Column(nullable = false)
    private Integer port;

    @Column(nullable = false)
    private Boolean repeat;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER, cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Callback> callbackList;

    public Service() {
    }

    public Service(String name, String hostname, Integer port, Boolean repeat) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
        this.repeat = repeat;
        this.callbackList = new ArrayList<>();
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

    public List<Callback> getCallbackList() {
        return callbackList;
    }

    public void setCallbackList(List<Callback> callbackList) {
        this.callbackList = callbackList;
    }
}
