package com.miwa.util;

import com.miwa.model.Callback;
import com.miwa.ws.pojo.CallbackPOJO;

import java.util.LinkedList;
import java.util.List;

public class PojoUtil {

    public static LinkedList<CallbackPOJO> toPojo(List<Callback> list) {
        LinkedList<CallbackPOJO> retList = new LinkedList<CallbackPOJO>();
        for (Callback c : list) {
            CallbackPOJO callbackPOJO = new CallbackPOJO(c.getCron(),c.getMessage(), c.getEndpoint(), c.getRequestType());
            callbackPOJO.setService_name(c.getService().getName());
            retList.add(callbackPOJO);
        }

        return retList;
    }
}
