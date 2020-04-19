package com.gamedash.api.client.time;

import java.time.Instant;

public class Time {

    private final long timestamp;

    public Time( long timestamp ) {

        this.timestamp = timestamp;

    }

    public long getTimestamp() {

        return this.timestamp;

    }

    public static Time fromTimestamp( int timestamp ) {

        return new Time( timestamp );

    }

    public static Time now() {

        return new Time(

            Instant.now().getEpochSecond()

        );

    }

}
