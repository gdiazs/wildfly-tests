package com.github.gdiazs.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("").build();
    }
}
