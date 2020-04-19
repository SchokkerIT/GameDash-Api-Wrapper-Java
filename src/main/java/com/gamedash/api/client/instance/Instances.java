package com.gamedash.api.client.instance;

import com.gamedash.api.client.ApiClient;
import com.gamedash.api.client.ApiQuery;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.schokkerit.restapi.client.response.QueryResponse;

public class Instances {

    public static Instance[] getAll() throws Exception {

        ApiQuery query = ApiClient.createQuery("instance/all");

        QueryResponse response = query.get();

        JsonArray jsonArray = response.getJsonObject().get("response").getAsJsonArray();

        Instance[] instances = new Instance[ jsonArray.size() ];

        int index = 0;

            for( JsonElement jsonElement : jsonArray ) {

                Instance instance = new Instance( jsonElement.getAsJsonObject().get("id").getAsString() );

                    instance.name = jsonElement.getAsJsonObject().get("name").getAsString();

                instances[ index ] = instance;

                index++;

            }

        return instances;

    }

}
