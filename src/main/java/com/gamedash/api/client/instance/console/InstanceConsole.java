package com.gamedash.api.client.instance.console;

import com.gamedash.api.client.instance.Instance;

public class InstanceConsole {

    private final Instance instance;
    private final InstanceConsoleIo io;

    public InstanceConsole(Instance instance ) {

        this.instance = instance;

        this.io = new InstanceConsoleIo( instance );

    }

    public InstanceConsoleIo getIo() {

        return this.io;

    }

}
