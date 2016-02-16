package com.manolosmobile.springboot.jersey;

import org.glassfish.jersey.server.ResourceConfig;

// Jersey won't work simultaneously with the other controllers, that's why this is commented out.
//@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JerseyGreetingController.class);
    }

}
