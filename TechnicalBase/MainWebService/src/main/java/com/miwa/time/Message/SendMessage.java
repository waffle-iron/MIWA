package com.miwa.time.Message;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SendMessage{

    public String message;
    public String hostname;
    public String endpoint;
    public int port;

    public void send() {
        Client client = Client.create();

        WebResource webResource = client
                .resource(hostname+ ":" +String.valueOf(port) + endpoint);

        ClientResponse response = webResource.accept("application/json")
                .post(ClientResponse.class, message);

        if (response.getStatus() != 201) {
            // Si on ne me renvoie pas 201 il y a eu un soucis
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

    }
}

