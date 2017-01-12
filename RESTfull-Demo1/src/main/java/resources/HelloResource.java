package resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/root")
public class HelloResource {

    @GET
    @Path("/hello")
    public String getMsg() {
        return "Hello World";
    }

}