package MyDropBookmarks.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello2")
public class HelloResource2 {

    @GET
    @Path("/result")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(){
        return "Hello2!!!";
    }

}
