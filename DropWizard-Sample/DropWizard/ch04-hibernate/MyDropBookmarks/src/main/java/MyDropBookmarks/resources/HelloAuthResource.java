package MyDropBookmarks.resources;

//import MyDropBookmarks.core.User;
import MyDropBookmarks.core.User;
import io.dropwizard.auth.Auth;
import org.eclipse.jetty.server.Authentication;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloauth")
public class HelloAuthResource {

    @Path("/a")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@Auth User user) {
        return "Hello-Auth!!!; user="+user.getName();
    }



}
