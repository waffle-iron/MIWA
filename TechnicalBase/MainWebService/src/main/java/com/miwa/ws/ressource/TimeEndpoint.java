package com.miwa.ws.ressource;

import com.google.gson.Gson;
import com.miwa.time.TimeManager;
import com.miwa.ws.pojo.SpeedPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/time")
public class TimeEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRatio() {
        Gson gson = new Gson();
        SpeedPOJO speedPOJO = new SpeedPOJO(TimeManager.GetInstance().getSpeed());
        return Response.status(200).entity(gson.toJson(speedPOJO)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setRatio(String message) {
        Gson gson = new Gson();
        SpeedPOJO speedPOJO = gson.fromJson(message, SpeedPOJO.class);
        TimeManager.GetInstance().setSpeed(speedPOJO.getSpeed());
        return Response.status(201).entity(gson.toJson(speedPOJO)).build();
    }
}
