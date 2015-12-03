package com.miwa.time.Message;

import com.miwa.model.Callback;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SendMessage{

    public Callback callback;

    public void send() {
        Client client = Client.create();

        WebResource webResource = client
                .resource(callback.getService().getHostname()+ ":" +String.valueOf(callback.getService().getPort()) + callback.getEndpoint());

        ClientResponse response;
        if ("POST".equals(callback.getRequestType()))
        {
            System.out.println("send post request");
            response = webResource.type("application/json")
                    .post(ClientResponse.class, callback.getMessage());

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
        }
        else if ("PUT".equals(callback.getRequestType()))
        {
            System.out.println("send put request");
            response = webResource.type("application/json")
                    .put(ClientResponse.class, callback.getMessage());

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
        }
        else if ("DELETE".equals(callback.getRequestType()))
        {
            System.out.println("send delete request");
            response = webResource.type("application/json")
                    .delete(ClientResponse.class, callback.getMessage());

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
        }
        else
        {
            System.out.println("send get request");
            response = webResource.get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
        }
    }
}

