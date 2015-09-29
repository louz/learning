package com.example;

import com.example.entity.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    /**
     *
     * @return
     */
    @GET
    @Path("status")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getIt2() {
        return Response.status(Response.Status.BAD_REQUEST).entity("bad request").build();
//        return Response.ok("good request").build();
    }

    /**
     *
     * @return
     */
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt3() {
        Person p = new Person();
        p.setId("1");
        p.setName("zhangsan");
        return Response.ok(p).build();
    }
}
