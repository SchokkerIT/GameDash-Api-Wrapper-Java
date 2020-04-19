package com.gamedash.api.client;

import java.io.IOException;

public class ApiClient {

    public static ApiQuery createQuery( String endpoint ) throws Exception {

        ApiQuery query = new ApiQuery(endpoint);

            query.getHeaders().create("X-Apitoken", ApiClient.getAuthenticationToken());

        return query;

    }

    public static String getAuthenticationToken() throws IOException {

        return Properties.getInstance().getProperty("auth.token");

    }

}
