package dto;

public class Materia {

    private int id;
    private String nombre;
    private String NRC;

    public Materia() {

    }

    public Materia(int id, String nombre, String NRC) {
        this.id = id;
        this.nombre = nombre;
        this.NRC = NRC;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNRC() {
        return NRC;
    }
}
