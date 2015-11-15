package com.miwa.time.Message;

import com.miwa.model.Callback;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SendMessage{

    public String message;
    public Callback callback;

    public void send() {
        Client client = Client.create();

        WebResource webResource = client
                .resource(callback.getService().getHostname()+ ":" +String.valueOf(callback.getService().getPort()) + callback.getEndpoint());

        ClientResponse response = webResource.accept("application/json")
                .post(ClientResponse.class, message);

        if (response.getStatus() != 201) {
            // Si on ne me renvoie pas 201 il y a eu un soucis
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

    }
}

