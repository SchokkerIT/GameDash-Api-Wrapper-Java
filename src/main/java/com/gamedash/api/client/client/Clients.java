package com.gamedash.api.client.client;

import com.gamedash.api.client.ApiClient;
import com.schokkerit.restapi.client.ApiQuery;
import com.schokkerit.restapi.client.response.QueryResponse;

public class Clients {

    public static Client get( String id ) throws Exception {

        ApiQuery query = ApiClient.createQuery("client/" + id);

        QueryResponse response = query.get();

        Client client = new Client( id );

            client.emailAddress = response.getJsonObject().get("response").getAsJsonObject().get("email").getAsJsonObject().get("address").getAsString();

        return client;

    }

}
