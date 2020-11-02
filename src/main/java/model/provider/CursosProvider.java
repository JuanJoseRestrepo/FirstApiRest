package model.provider;

import db.MySQLConnection;
import entity.Curso;
import model.dto.CursoDTO;

public class CursosProvider {

    //Proveer informacion
    public void  getCurso(){

    }

    //Proveer las acciones
    public void  InsertCurso(Curso curso){

        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO cursos(nombre,programa,profesorID) VALUES('$nombre','$programa',$profesor)";
        sql = sql.replace("$nombre", curso.getNombre());
        sql = sql.replace("$programa", curso.getPrograma());
        sql = sql.replace("$profesor", "" + curso.getProfesorID());
        connection.executeSQL(sql);

    }

    public void  updateCurso(){

    }

    public void  deleteCurso(){

    }

    //CRUD: Create, Read, Update y Delete

    public Curso mapFromDTO(CursoDTO cursos){
        Curso curso = new Curso();
        curso.setNombre(cursos.getNombre());
        curso.setPrograma(cursos.getPrograma());
        curso.setProfesorID(cursos.getProfesor().getId());
        return curso;
    }

}
