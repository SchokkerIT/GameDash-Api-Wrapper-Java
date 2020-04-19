package com.gamedash.api.client.instance.console;

import com.gamedash.api.client.time.Time;

public class InstanceConsoleIoOutputLine {

    private final String value;
    private final Boolean isError;
    private final Time timeCreated;

    public InstanceConsoleIoOutputLine( String value, Boolean isError, Time timeCreated ) {

        this.value = value;
        this.isError = isError;
        this.timeCreated = timeCreated;

    }

    public String getValue() {

        return this.value;

    }

    public Boolean isError() {

        return this.isError;

    }

    public Time getTimeCreated() {

        return this.timeCreated;

    }

}
