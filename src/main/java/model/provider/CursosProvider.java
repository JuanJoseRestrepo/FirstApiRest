package model.provider;

import db.MySQLConnection;
import entity.Curso;
import entity.Profesor;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursosProvider {

    //Proveer informacion
    public ArrayList<CursoDTO> getAllCursos() {
        ArrayList<CursoDTO> cursosDTO = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        ProfesoresProvider profesorProvider = new ProfesoresProvider();
        try {

            String sql = "SELECT  nombre , programa, profesorID FROM cursos";
            ResultSet resultSet = connection.Query(sql);

            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(resultSet.getString(1));
                cursoDTO.setPrograma(resultSet.getString(2));
                ProfesorDTO profe =  profesorProvider.getPartProfesorById(resultSet.getInt(3));
                cursoDTO.setProfesor(profe);
                cursosDTO.add(cursoDTO);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return cursosDTO;
    }

    public ArrayList<CursoDTO> getAllCursosByProfesor(int id) {
        ArrayList<CursoDTO> cursosDTO = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {

            String sql = "SELECT  nombre , programa FROM cursos WHERE profesorID=" + id;
            ResultSet resultSet = connection.Query(sql);

            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(resultSet.getString(1));
                cursoDTO.setPrograma(resultSet.getString(2));
                cursosDTO.add(cursoDTO);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return cursosDTO;
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
