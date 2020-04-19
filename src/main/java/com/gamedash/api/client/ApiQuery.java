package com.gamedash.api.client;

import com.schokkerit.restapi.client.ApiQueryException;

public class ApiQuery extends com.schokkerit.restapi.client.ApiQuery {

    public ApiQuery( String endpoint ) throws Exception {

        super( endpoint );

        this.getResponseErrorHandlerManager().registerHandler(( response ) -> {

            if( response.isError() ) {

                throw new ApiQueryException(

                    response.getJsonObject().get("error").getAsJsonObject().get("status").getAsString()

                );

            }

        });

    }

    @Override
    protected String getAddress() throws Exception {

        return "http" + ( this.isSecure() ? "s" : "" ) + "://" + Properties.getInstance().getProperty("domain") + "/v" + Properties.getInstance().getProperty("version") + "/" + this.getEndpoint();

    }

    @Override
    protected Boolean isSecure() throws Exception {

        return Properties.getInstance().getProperty("isSecure").equals("true");

    }

}
