package services;

import model.dto.CursoDTO;
import model.dto.ProfesorDTO;
import model.provider.CursosProvider;
import model.provider.ProfesoresProvider;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("cursos")

public class CursoServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public dto.Response createProfesor(CursoDTO cursoDTO){
        CursosProvider cursoProvider = new CursosProvider();

        cursoProvider.InsertCurso(cursoProvider.mapFromDTO(cursoDTO));

        return new dto.Response("Operacion exitosa");

    }

}
