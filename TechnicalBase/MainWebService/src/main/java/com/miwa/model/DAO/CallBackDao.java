package com.miwa.model.DAO;

import com.miwa.model.Domain.Callback;

import java.util.List;


public class CallBackDao extends MasterDao<Callback> {

    public List<Callback> getAll() {
        return super.getAll(Callback.class);
    }
}
