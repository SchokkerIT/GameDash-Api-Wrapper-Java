package com.gamedash.api.client.client;

public class Client {

    private String id;

    public String emailAddress;

    public Client( String id ) {

        this.id = id;

    }

    public String getId() {

        return this.id;

    }

    public String getEmailAddress() {

        return this.emailAddress;

    }

}
