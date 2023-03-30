package Modelo;
public class Entrenadores {
    private int id_entrenador;
    private String nombre;
    private int edad;
    private int id_equipo;

    public Entrenadores(int id_entrenador, String nombre, int edad, int id_equipo) {
        this.id_entrenador = id_entrenador;
        this.nombre = nombre;
        this.edad = edad;
        this.id_equipo = id_equipo;
    }

    public int getId_entrenador() {

        return id_entrenador;
    }
    public void setId_entrenador(int id_entrenador) {
        this.id_entrenador = id_entrenador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getId_equipo() {
        return id_equipo;
    }
    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    @Override
    public String toString() {
        return "Entrenadores [id_entrenador=" + id_entrenador + ", nombre=" + nombre + ", edad=" + edad + ", id_equipo="
                + id_equipo + "]";
    }


}