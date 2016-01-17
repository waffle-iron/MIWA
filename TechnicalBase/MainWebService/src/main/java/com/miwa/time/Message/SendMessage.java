package com.miwa.time.Message;

import com.miwa.model.Domain.Callback;
import com.miwa.time.TimeManager;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SendMessage{

    public Callback callback;

    public void send() {
//        System.out.println("now : " + new Date() + "  |  virtual date : " + TimeManager.GetInstance().getCurrentDate() + "   |   " + callback.getMessage());
        try {
            Client client = Client.create();

            WebResource webResource = client
                    .resource(callback.getService().getHostname() + ":" + String.valueOf(callback.getService().getPort()) + callback.getEndpoint());

            ClientResponse response;
            System.out.println("Begin send message : current date : " + TimeManager.GetInstance().getCurrentDate()
                    + ", current speed : " + TimeManager.GetInstance().getSpeed()
                    + ", current service : " + callback.getService()
                    + ", current endpoint : " + callback.getEndpoint()
                    + ", current RequestType : " + callback.getRequestType()
                    + ", current message : " + callback.getMessage()
                    + ", current cron : " + callback.getCron());

            if ("POST".equals(callback.getRequestType())) {
                System.out.println("send post request");
                response = webResource.post(ClientResponse.class, callback.getMessage());

                if (response.getStatus() != 201) {
                    throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
                }
            } else if ("PUT".equals(callback.getRequestType())) {
                System.out.println("send put request");
                response = webResource.put(ClientResponse.class, callback.getMessage());

                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
                }
            } else if ("DELETE".equals(callback.getRequestType())) {
                System.out.println("send delete request");
                response = webResource.delete(ClientResponse.class, callback.getMessage());

                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
                }
            } else {
                System.out.println("send get request");
                response = webResource.get(ClientResponse.class);
                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
                }
            }
        }
        catch (Exception ex){
            System.err.println(ex.getMessage() + "   |   " + callback.getService() + "   |   " + callback.getEndpoint()
                    + "   |   " + callback.getRequestType() + "   |   " + callback.getMessage());
        }
    }
}

