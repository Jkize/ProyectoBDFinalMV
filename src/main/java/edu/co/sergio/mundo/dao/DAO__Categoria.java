package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Categoria; 
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @since
 *
 */
public class DAO__Categoria implements DAO<Categoria> {

    private final Connection conexion;

    public DAO__Categoria() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
    }

    @Override
    public List<Categoria> Obtener() throws SQLException {
        List<Categoria> categorias = new ArrayList<Categoria>();
        String query = "SELECT * FROM Categoria";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Categoria cat = new Categoria(rs.getInt("codigo"), rs.getString("nombre"));
                categorias.add(cat);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return categorias;

    }
    
     public Categoria Buscar(int id) throws SQLException {
        Categoria categoria = null;
        String query = "SELECT * FROM Categoria WHERE codigo=" + id;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                categoria = new Categoria(rs.getInt("codigo"), rs.getString("nombre"));

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return categoria;

    }

    @Override
    public boolean Crear(Categoria t) throws SQLException {
        boolean result = false;
        String query = "insert into Categoria (nombre)" + " values (?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }
            preparedStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean Actualizar(Categoria t) throws SQLException {

        String query = "UPDATE Categoria set nombre=? WHERE codigo=" + t.getCodigo();
        boolean result = false;
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }
            preparedStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean Eliminar(Categoria t) throws SQLException {
        boolean result = false;
        String query = "delete from Categoria where codigo = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt(1, t.getCodigo());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }
            preparedStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    
    
}
