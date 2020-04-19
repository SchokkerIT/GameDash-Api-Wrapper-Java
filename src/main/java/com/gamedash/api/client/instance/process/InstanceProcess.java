package com.gamedash.api.client.instance.process;

import com.gamedash.api.client.ApiClient;
import com.gamedash.api.client.ApiQuery;
import com.gamedash.api.client.instance.Instance;
import com.schokkerit.restapi.client.response.QueryResponse;

public class InstanceProcess {

    private final Instance instance;

    public InstanceProcess(Instance instance ) {

        this.instance = instance;

    }

    public void start() throws Exception {

        ApiQuery apiQuery = ApiClient.createQuery("instance/" + this.instance.getId() + "/process");

        apiQuery.post();

    }

    public void stop() throws Exception {

        ApiQuery apiQuery = ApiClient.createQuery("instance/" + this.instance.getId() + "/process");

        apiQuery.delete();

    }

    public void restart() throws Exception {

        ApiQuery apiQuery = ApiClient.createQuery("instance/" + this.instance.getId() + "/process/restart");

        apiQuery.post();

    }

    public boolean getStatus() throws Exception {

        ApiQuery apiQuery = ApiClient.createQuery("instance/" + this.instance.getId() + "/process/status");

        QueryResponse response = apiQuery.get();

        return response.getJsonObject().get("response").getAsBoolean();

    }

}
