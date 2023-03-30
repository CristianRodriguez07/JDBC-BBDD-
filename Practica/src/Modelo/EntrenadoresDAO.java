package Modelo;

import java.util.ArrayList;

public interface EntrenadoresDAO {
    public ArrayList<Entrenadores> SelectAll();
    public ArrayList<Entrenadores> SelectById( int id);

    ArrayList<Entrenadores> SelectByName(String nombre);

    public Entrenadores SelectByEquipoId(int id_equipo);

    Entrenadores SelectByEntrenadorId(int id_entrenador);

    boolean InsertEntrenador(int id, String nombre, int edad, int id_equipo);

    boolean UpdateEntrenador(int entrenador_id, String nombre, int edad, int id_equipo);

    boolean DeleteEntrenador(int entrenador_id);


}
