package com.miwa.ws;

import com.google.gson.Gson;
import com.miwa.ws.model.Ratio;
import com.miwa.ws.model.SubscribedService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("/app")
public class Service {
    //TODO remove this
    private static List<SubscribedService> services = new LinkedList<SubscribedService>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubcribedApp() {
        Gson gson = new Gson();
        // TODO get services in Database
        return Response.status(200).entity(gson.toJson(services)).build();
    }

    @POST
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApp(String message) {
        Gson gson = new Gson();
        SubscribedService service = gson.fromJson(message, SubscribedService.class);

        // TODO add service in Database
        services.add(service);
        return Response.status(201).entity(gson.toJson(service)).build();

    }

}
