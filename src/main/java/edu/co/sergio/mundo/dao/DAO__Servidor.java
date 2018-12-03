package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Servidor;
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
public class DAO__Servidor implements DAO<Servidor> {

    private final Connection conexion;

    public DAO__Servidor() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
    }

    @Override
    public List<Servidor> Obtener() throws SQLException {
        List<Servidor> servidores = new ArrayList<Servidor>();
        String query = "SELECT * FROM Servidor";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Servidor ser = new Servidor(rs.getInt("codigo"), rs.getString("nombre"));
                servidores.add(ser);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return servidores;

    }

    public Servidor Buscar(int id) throws SQLException {
        Servidor serv = null;
        String query = "SELECT * FROM Servidor WHERE codigo=" + id;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                serv = new Servidor(rs.getInt("codigo"), rs.getString("nombre"));

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return serv;

    }

    @Override
    public boolean Crear(Servidor t) throws SQLException {
        boolean result = false;
        String query = " insert into Servidor (Nombre) values (?)";
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
    public boolean Actualizar(Servidor t) throws SQLException {
        boolean result = false;
        String query = "update Servidor set Nombre = ? where codigo = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());
            preparedStmt.setInt(2, t.getCodigo());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean Eliminar(Servidor t) throws SQLException {
        boolean result = false;
        String query = "delete from Servidor where codigo = ?";
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
