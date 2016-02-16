package com.manolosmobile.springboot.jersey;

import com.manolosmobile.springboot.model.Greeting;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class JerseyGreetingController {

    private final AtomicLong counter = new AtomicLong();
    private List<Greeting> greetings = new ArrayList<>();

    @GET
    @Path("/jcreate")
    public Greeting createGreeting(@QueryParam("name") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), "Hello, " + name);
        greetings.add(greeting);
        return greeting;
    }

    @GET
    @Path("/jget")
    public Greeting getGreetingByRequestParam(@QueryParam("id") long id) {
        return getGreeting(id);
    }

    @GET
    @Path("/jget/{id}")
    public Greeting getGreetingByPathVariable(@PathParam("id") long id) {
        return getGreeting(id);
    }

    private Greeting getGreeting(long id) {
        return greetings.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

    @GET
    @Path("/jgetGreetings")
    public List<Greeting> getGreetings() {
        return greetings;
    }

}
