package com.miwa.ws.ressource;

import com.google.gson.Gson;
import com.miwa.dao.CallBackDAO;
import com.miwa.dao.ServiceDAO;
import com.miwa.model.Callback;
import com.miwa.model.Service;
import com.miwa.time.TimeManager;
import com.miwa.util.PojoUtil;
import com.miwa.ws.pojo.CallbackPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/callback")
public class CallBackEndpoint {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCallBack() {
        Gson gson = new Gson();
        List<Callback> callbacks = new CallBackDAO().getAll();
        System.out.println("there is " + callbacks.size());
        return Response.status(200).entity(gson.toJson(PojoUtil.toPojo(callbacks))).build();
    }

    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCallback(String message) {

        Gson gson = new Gson();
        CallbackPOJO callbackPOJO = gson.fromJson(message, CallbackPOJO.class);
        Service service = new ServiceDAO().findByName(callbackPOJO.getService_name());

        Callback callback = new Callback(callbackPOJO.getCron(), callbackPOJO.getMessage(), callbackPOJO.getEndpoint(), service, callbackPOJO.getRequest_type());
        new CallBackDAO().insert(callback);

        try{
            TimeManager.GetInstance().AddAlarmToApplication(callback);
            return Response.status(201).entity(gson.toJson(callbackPOJO)).build();
        }
        catch (Exception e){
            return Response.status(400).entity(gson.toJson(e.getMessage())).build();
        }
    }
}
