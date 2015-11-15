package com.miwa.ws.ressource;

import com.google.gson.Gson;
import com.miwa.dao.CallBackDAO;
import com.miwa.dao.ServiceDAO;
import com.miwa.model.Callback;
import com.miwa.model.Service;
import com.miwa.ws.pojo.CallbackPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("/callback")
public class CallBackEndpoint {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubcribedApp() {
        Gson gson = new Gson();
        // TODO get services in Database
        List<Callback> callbacks = new CallBackDAO().getAll();
        return Response.status(200).entity(gson.toJson(callbacks)).build();
    }

    @POST
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApp(String message) {
        Gson gson = new Gson();
        CallbackPOJO callbackPOJO = gson.fromJson(message, CallbackPOJO.class);
        Service service = new ServiceDAO().findByName(callbackPOJO.getService_name());

        Callback callback = new Callback(callbackPOJO.getCron(), callbackPOJO.getMessage(), callbackPOJO.getEndpoint(), service);
        new CallBackDAO().insert(callback);
        return Response.status(201).entity(gson.toJson(callbackPOJO)).build();

    }
}
