package org.acme;

import org.acme.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {

    public static final String TOKEN = "dev";

    //Dependency Injection
    @Inject
    private GreetingService greetingServcice;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingServcice.sayHello();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return greetingServcice.sayHello(name);
    }

    @GET
    @Path("/html/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWithId(@PathParam("id") String id) {
        return "Hello RESTEasy from Ron " + id;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(@QueryParam("token") String aName, @HeaderParam("token") String hName) {
        String token = hName != null ? hName : aName;
        if(!TOKEN.equals(token)) {
            throw new RuntimeException("Unauthorized");
        }
        return token;
    }
}