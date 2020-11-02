package services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("echo")
public class EchoService {

    @GET
    @Path("index")
    public String index(){
        return "echo";
    }

    /*@POST
    @Consumes("application/json")
    @Path("user")
    public String createUser(Materia ma){
            String m;
            MySQLConnection my = new MySQLConnection();
            my.addMaterias(ma);
            return m = "OK";
    }*/

}
