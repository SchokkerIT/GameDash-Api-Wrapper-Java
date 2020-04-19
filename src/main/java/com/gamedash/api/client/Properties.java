package com.gamedash.api.client;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

    public static java.util.Properties getInstance() throws IOException {

        InputStream inputStream = Properties.class.getClassLoader().getResourceAsStream("client.properties");

        if( inputStream == null ) {

            throw new IOException("Could not find client.properties");

        }

        java.util.Properties properties = new java.util.Properties();

        properties.load( inputStream );

        return properties;

    }

}
