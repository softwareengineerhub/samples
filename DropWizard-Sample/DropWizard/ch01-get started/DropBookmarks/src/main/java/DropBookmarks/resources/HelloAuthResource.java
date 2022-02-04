package DropBookmarks.resources;

import DropBookmarks.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-auth")
public class HelloAuthResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@Auth User user) {
        return "Hello-Auth!!!";
    }

}
