package services;

import model.dto.CursoDTO;
import model.dto.ProfesorDTO;
import model.provider.CursosProvider;
import model.provider.ProfesoresProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Stateless
@Path("cursos")

public class CursoServices {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("create")
    public dto.Response createCurso(CursoDTO cursoDTO){
        CursosProvider cursoProvider = new CursosProvider();

        cursoProvider.InsertCurso(cursoProvider.mapFromDTO(cursoDTO));

        return new dto.Response("Operacion exitosa");

    }


    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("all")
    public ArrayList<CursoDTO> getAllCursos(){
        CursosProvider provider = new CursosProvider();
        ArrayList<CursoDTO> cursosDTOS = provider.getAllCursos();
        return  cursosDTOS;
    }

}
