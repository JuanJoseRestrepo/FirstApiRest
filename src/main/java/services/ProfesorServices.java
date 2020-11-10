package services;

import dto.Response;
import javafx.beans.DefaultProperty;
import model.dto.ProfesorDTO;
import model.provider.ProfesoresProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("profesores")
public class ProfesorServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public dto.Response createProfesor(ProfesorDTO profesorDTO){
        ProfesoresProvider profesorProvider = new ProfesoresProvider();

        profesorProvider.InsertProfesor(profesorProvider.mapFromDTO(profesorDTO));

        return new Response("Operacion exitosa");

    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("{id}")
    public ProfesorDTO getProfesor(@PathParam("id") String id){
        ProfesoresProvider provider = new ProfesoresProvider();
        ProfesorDTO profe = provider.getProfesorById(Integer.parseInt(id));
        return profe;

    }
}
