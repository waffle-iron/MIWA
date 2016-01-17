package com.miwa.ws.ressource;

import com.google.gson.Gson;
import com.miwa.model.DAO.CallBackDao;
import com.miwa.model.DAO.ServiceDao;
import com.miwa.model.Domain.Callback;
import com.miwa.model.Domain.Service;
import com.miwa.time.TimeManager;
import com.miwa.ws.pojo.SubscribedServicePOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/app")
public class ServiceEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubcribedApp() {
        Gson gson = new Gson();
        List<Service> list = new ServiceDao().getAll().stream().distinct().collect(Collectors.toList());
        for (Service service : list)
            service.setCallbackList(null);
        return Response.status(200).entity(gson.toJson(list)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addApp(String message) {
        Gson gson = new Gson();
        SubscribedServicePOJO servicePOJO = gson.fromJson(message, SubscribedServicePOJO.class);

        ServiceDao ServiceDao = new ServiceDao();
        Service service;
        if ((service = ServiceDao.findByName(servicePOJO.getName())) != null) {
            CallBackDao callBackDao = new CallBackDao();
            for (Callback callback : service.getCallbackList()) {
                TimeManager.GetInstance().deleteAlarm(callback.getCallbackid());
                callBackDao.delete(callback);
            }
        } else
            ServiceDao.insert(servicePOJO.toModel());

        return Response.status(201).entity(gson.toJson(servicePOJO)).build();
    }

}
