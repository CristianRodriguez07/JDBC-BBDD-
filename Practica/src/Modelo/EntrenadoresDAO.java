package Modelo;

import java.util.ArrayList;

public interface EntrenadoresDAO {
    public ArrayList<Entrenadores> SelectAll();
    public ArrayList<Entrenadores> SelectById( int id);

    ArrayList<Entrenadores> SelectByName(String nombre);

    public Entrenadores SelectByEquipoId(int id_equipos);

    Entrenadores SelectByEntrenadorId(int id_entrenador);

    boolean InsertEntrenador(int id, String nombre, int edad, int id_equipos);

    boolean UpdateEntrenador(int id, String nombre, int edad, int id_equipos);

    boolean DeleteEntrenador(int id);


}
