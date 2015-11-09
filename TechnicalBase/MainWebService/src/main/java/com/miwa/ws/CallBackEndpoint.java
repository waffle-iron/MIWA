package com.miwa.ws;

import com.google.gson.Gson;
import com.miwa.ws.model.Callback;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("/callback")
public class CallBackEndpoint {

    //TODO remove this
    private static List<Callback> callbacks = new LinkedList<Callback>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubcribedApp() {
        Gson gson = new Gson();
        // TODO get services in Database
        return Response.status(200).entity(gson.toJson(callbacks)).build();
    }

    @POST
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApp(String message) {
        Gson gson = new Gson();
        Callback callback = gson.fromJson(message, Callback.class);

        // TODO add service in Database
        callbacks.add(callback);
        return Response.status(201).entity(gson.toJson(callback)).build();

    }
}
