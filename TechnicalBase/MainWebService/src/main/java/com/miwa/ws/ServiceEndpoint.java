package com.miwa.ws;

import com.google.gson.Gson;
import com.miwa.dao.ServiceDAO;
import com.miwa.model.Service;
import com.miwa.ws.model.SubscribedService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/app")
public class ServiceEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubcribedApp() {
        Gson gson = new Gson();
        List<Service> list = new ServiceDAO().getAll();
        return Response.status(200).entity(gson.toJson(list)).build();
    }

    @POST
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApp(String message) {
        Gson gson = new Gson();
        SubscribedService service = gson.fromJson(message, SubscribedService.class);

        ServiceDAO serviceDAO = new ServiceDAO();
        serviceDAO.AddService(service.toModel());

        return Response.status(201).entity(gson.toJson(service)).build();

    }

}
