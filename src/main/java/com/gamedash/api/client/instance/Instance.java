package com.gamedash.api.client.instance;

import com.gamedash.api.client.ApiClient;
import com.gamedash.api.client.ApiQuery;
import com.gamedash.api.client.instance.console.InstanceConsole;
import com.gamedash.api.client.instance.process.InstanceProcess;

public class Instance {

    private final String id;
    private final InstanceConsole console = new InstanceConsole( this );
    private final InstanceProcess process = new InstanceProcess( this );

    public String name;

    public Instance( String id ) {

        this.id = id;

    }

    public String getId() {

        return this.id;

    }

    public String getName() {

        return this.name;

    }

    public void setName( String name ) throws Exception {

        ApiQuery query = ApiClient.createQuery("instance/" + this.getId() + "/name");

        query.getParameters().create("name", name);

        query.put();

        this.name = name;

    }

    public InstanceConsole getConsole() {

        return this.console;

    }

    public InstanceProcess getProcess() {

        return this.process;

    }

}
