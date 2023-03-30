package Controlador;

import Modelo.ConexionJDBC;
import Modelo.Entrenadores;
import Modelo.EntrenadoresDAO;

import java.sql.*;
import java.util.ArrayList;

public class ControladorJDBC implements EntrenadoresDAO {
    public final String SELECT_ALL = "SELECT * FROM entrenadores";
    public final String SELECT_BY_ID = "SELECT * FROM entrenadores WHERE id_entrenador = ?";
    public final String SELECT_BY_NAME = "SELECT * FROM entrenadores WHERE nombre = ?";
    public final String DELETE_BY_ID = "DELETE FROM entrenadores WHERE id_entrenador = ?";
    public final String INSERT = "INSERT INTO entrenadores VALUES (?, ?, ?, ?)";
    public final String UPDATE_BY_ID = "UPDATE entrenadores SET nombre = ?, edad = ?, id_equipo = ? WHERE id_entrenador = ?";

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
                Entrenadores e = new Entrenadores(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4));
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_NAME);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            ArrayList<Entrenadores> lista = new ArrayList<Entrenadores>();
            while (rs.next()) {
                Entrenadores e = new Entrenadores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                lista.add(e);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Entrenadores SelectByEquipoId(int id_equipos) {

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id_equipos);
            ResultSet rs = (ResultSet) ps.executeQuery();
            rs.next();
            Entrenadores e = new Entrenadores(rs.getInt(1), rs.getString(2), rs.getInt(1), rs.getInt(2));
            return e;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Entrenadores SelectByEntrenadorId(int id_entrenador) {
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id_entrenador);
            ResultSet rs = (ResultSet) ps.executeQuery();
            rs.next();
            Entrenadores e = new Entrenadores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            return e;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean InsertEntrenador(int id, String nombre, int edad, int id_equipos) {
    try {
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(INSERT);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setInt(3, edad);
        ps.setInt(4, id_equipos);
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
    }

    @Override
    public boolean UpdateEntrenador(int id, String nombre, int edad, int id_equipos) {
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(UPDATE_BY_ID);
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.setInt(3, edad);
            ps.setInt(4, id_equipos);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteEntrenador(int id) {
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
