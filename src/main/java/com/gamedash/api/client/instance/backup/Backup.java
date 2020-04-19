package com.gamedash.api.client.instance.backup;

import com.gamedash.api.client.ApiClient;
import com.gamedash.api.client.ApiQuery;
import com.gamedash.api.client.instance.Instance;
import com.gamedash.api.client.tracker.Tracker;
import com.gamedash.api.client.tracker.Trackers;
import com.google.gson.JsonObject;
import com.schokkerit.restapi.client.response.QueryResponse;

public class Backup {

    private final Instance instance;

    public Backup( Instance instance ) {

        this.instance = instance;

    }

    public Tracker create() throws Exception {

        ApiQuery query = ApiClient.createQuery("instance/" + this.instance.getId() + "/backup");

        QueryResponse response = query.post();

        JsonObject responseObject = response.getJsonObject().get("response").getAsJsonObject();

        return Trackers.get(

            responseObject.get("tracker").getAsJsonObject().get("id").getAsString()

        );

    }

}
