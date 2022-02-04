package DropBookmarks.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MyRootResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(){
        return "This is root!!!";
    }

}
