package model.provider;

import db.MySQLConnection;
import entity.Profesor;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesoresProvider {


    //Proveer informacion
    public ProfesorDTO getProfesorById(int id) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        CursosProvider cursoProvider = new CursosProvider();
        MySQLConnection connection = new MySQLConnection();
        try {
            
            String sql = "SELECT id, nombre , facultad FROM profesores WHERE id=" + id;
            ResultSet resultSet = connection.Query(sql);

            while (resultSet.next()){

                profesorDTO.setId(resultSet.getInt(1));
                profesorDTO.setNombre(resultSet.getString(2));
                profesorDTO.setFacultad(resultSet.getString(3));
                ArrayList<CursoDTO> cursitos = cursoProvider.getAllCursosByProfesor(profesorDTO.getId());
                profesorDTO.setCursos(cursitos);

            }

        }catch (SQLException throwables) {
        throwables.printStackTrace();
        }
        connection.disconnect();
        return  profesorDTO;
    //Control alt L
    }

    public ProfesorDTO getPartProfesorById(int id) {
        ProfesorDTO profesorDTO = new ProfesorDTO();

        MySQLConnection connection = new MySQLConnection();
        try {

            String sql = "SELECT id, nombre , facultad FROM profesores WHERE id=" + id;
            ResultSet resultSet = connection.Query(sql);

            while (resultSet.next()){

                profesorDTO.setId(resultSet.getInt(1));
                profesorDTO.setNombre(resultSet.getString(2));
                profesorDTO.setFacultad(resultSet.getString(3));

            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return  profesorDTO;
        //Control alt L
    }

    //Proveer las acciones
    public void InsertProfesor(Profesor profesor) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO profesores(nombre,facultad) VALUES('$nombre','$facultad')";
        sql = sql.replace("$nombre", profesor.getNombre());
        sql = sql.replace("$facultad", profesor.getFacultad());
        connection.executeSQL(sql);
    }

    public void updateProfesor() {

    }

    public void deleteProfesor() {

    }

    public Profesor mapFromDTO(ProfesorDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.getNombre());
        profesor.setFacultad(dto.getFacultad());
        return profesor;
    }

    public ProfesorDTO mapToDTO(Profesor p){
        ProfesorDTO profesordto = new ProfesorDTO();
        profesordto.setId(p.getId());
        profesordto.setNombre(p.getNombre());
        profesordto.setFacultad(p.getFacultad());
        return  profesordto;
    }

    //CRUD: Create, Read, Update y Delete


}
