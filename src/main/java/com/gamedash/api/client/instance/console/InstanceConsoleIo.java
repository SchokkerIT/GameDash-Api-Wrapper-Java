package com.gamedash.api.client.instance.console;

import com.schokkerit.restapi.client.response.QueryResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gamedash.api.client.ApiClient;
import com.gamedash.api.client.ApiQuery;
import com.gamedash.api.client.instance.Instance;
import com.gamedash.api.client.time.Time;

public class InstanceConsoleIo {

    private Instance instance;

    public InstanceConsoleIo(Instance instance ) {

        this.instance = instance;

    }

    public InstanceConsoleIoOutputLine[] getOutput() throws Exception {

        ApiQuery query = ApiClient.createQuery("instance/" + this.instance.getId() + "/console/io/output");

        QueryResponse response = query.get();

        JsonArray array = response.getJsonObject().get("response").getAsJsonArray();

        InstanceConsoleIoOutputLine[] outputLines = new InstanceConsoleIoOutputLine[ array.size() ];

            int index = 0;

            for( JsonElement jsonElement : array ) {

                JsonObject jsonObject = jsonElement.getAsJsonObject();

                outputLines[ index ] = new InstanceConsoleIoOutputLine(

                    jsonObject.getAsString(),
                    jsonObject.getAsBoolean(),
                    Time.fromTimestamp(

                        jsonObject.get("timestamp").getAsJsonObject().get("created").getAsInt()

                    )

                );

                index++;

            }

        return outputLines;

    }

    public void sendInput( String input ) throws Exception {

        ApiQuery query = ApiClient.createQuery("instance/" + this.instance.getId() + "/console/io/input");

        query.getParameters().create("input", input);

        query.post();

    }

    public Boolean acceptInput() throws Exception {

        ApiQuery query = ApiClient.createQuery("instance/" + this.instance.getId() + "/console/io/input/accepts");

        QueryResponse response = query.post();

        return response.getJsonObject().get("response").getAsBoolean();

    }

}
