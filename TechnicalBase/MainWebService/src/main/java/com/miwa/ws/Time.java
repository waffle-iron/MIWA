package com.miwa.ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miwa.ws.model.Ratio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/time")
public class Time {
    
    private static Ratio ratio = new Ratio();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRatio() {
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(ratio)).build();
    }

    @PUT
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setRatio(String message) {
        Gson gson = new Gson();
        ratio.setRatio(gson.fromJson(message, Ratio.class).getRatio());
        return Response.status(201).entity(gson.toJson(ratio)).build();
    }
}
