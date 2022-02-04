package MyDropBookmarks.resources;

//import MyDropBookmarks.core.User;
import MyDropBookmarks.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloauth2")
public class HelloAuthResource2 {

    @Path("/b")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return "Hello-Auth!!!; user=";
    }



}
