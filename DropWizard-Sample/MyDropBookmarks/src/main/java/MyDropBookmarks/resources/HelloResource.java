package MyDropBookmarks.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(){
        return "Hello!!!";
    }

    @GET
    @Path("/v2")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@QueryParam("flag") Boolean flag){
        return "Hello!!!flag="+flag;
    }

}
