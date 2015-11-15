package com.miwa.ws;

import com.google.gson.Gson;
import com.miwa.time.TimeManager;
import com.miwa.ws.model.Speed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/time")
public class TimeEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRatio() {
        Gson gson = new Gson();
        Speed speed = new Speed(TimeManager.GetInstance().getSpeed());
        return Response.status(200).entity(gson.toJson(speed)).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setRatio(String message) {
        Gson gson = new Gson();
        Speed speed = gson.fromJson(message, Speed.class);
        TimeManager.GetInstance().setSpeed(speed.getSpeed());
        return Response.status(201).entity(gson.toJson(speed)).build();
    }
}
