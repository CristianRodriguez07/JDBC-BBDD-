package Controlador;

import Modelo.ConexionJDBC;
import Modelo.Entrenadores;
import Modelo.EntrenadoresDAO;

import java.sql.*;
import java.util.ArrayList;

public class ControladorJDBC implements EntrenadoresDAO {
    public final String SELECT_ALL = "SELECT * FROM entrenadores";
    public final String SELECT_BY_ID = "SELECT * FROM entrenadores WHERE id = ?";
    public final String SELECT_BY_NAME = "SELECT * FROM entrenadores WHERE nombre = ?";
    public final String DELETE_BY_ID = "DELETE FROM entrenadores WHERE id = ?";
    public final String INSERT = "INSERT INTO entrenadores VALUES (?, ?, ?, ?)";
    public final String UPDATE_BY_ID = "UPDATE entrenadores SET nombre = ? WHERE id = ?";

    private Connection con;

    public ControladorJDBC() {
        ConexionJDBC conexion = new ConexionJDBC("root", "3306", "127.0.0.1", "jdbc:mysql", "equipo_futbol", "Admin", "jdbc:mysql://127.0.0.1:3306/equipo_futbol");
        try {
            con = conexion.AbrirConexion();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            con = null;
        }

    }

    @Override
    public ArrayList<Entrenadores> SelectAll() {
        ArrayList<Entrenadores> lista = new ArrayList<Entrenadores>();
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);
            while (rs.next()) {
                //rellenamos el arrayList de Entrenadores
                Entrenadores e = new Entrenadores(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4));
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //Seteamos el arraylist a null
            lista = null;
        }
        return lista;
    }

    @Override
    public ArrayList<Entrenadores> SelectById(int id) {
        ArrayList<Entrenadores> lista = new ArrayList<Entrenadores>();
           try {
               PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID);
               ps.setInt(1, id);
            ResultSet rs =ps.executeQuery(SELECT_BY_ID);
            while (rs.next()) {
                Entrenadores e = new Entrenadores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
           }
        return lista;
    }

    @Override
    public ArrayList<Entrenadores> SelectByName(String nombre) {
        return null;
    }

    @Override
    public Entrenadores SelectByEquipoId(int id_equipo) {

        try {

            PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID);
            //"SELECT * FROM EMPLOYEES where employee_id = ?"
            ps.setInt(1, id_equipo);

            ResultSet rs = (ResultSet) ps.executeQuery();

            rs.next();
            //Para obtener los datos: rs.getInt(1), rs.getString(2)...;
            //rellenamos el arrayList de employee
            Entrenadores e = new Entrenadores(rs.getInt(1), rs.getString(2), rs.getInt(1), rs.getInt(2));
            return e;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Entrenadores SelectByEntrenadorId(int id_entrenador) {

        return null;
    }


    @Override
    public boolean InsertEntrenador(int id, String nombre, int edad, int id_equipo) {

        return false;
    }

    @Override
    public boolean UpdateEntrenador(int entrenador_id, String nombre, int edad, int id_equipo) {

        return false;
    }

    @Override
    public boolean DeleteEntrenador(int entrenador_id) {

        return false;
    }
}
