package com.miwa.ws.pojo;

import java.util.Date;

/**
 * Created by Calu on 14/01/2016.
 */
public class CurrentDatePojo {

    private Date actualDate;

    public CurrentDatePojo(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }
}
