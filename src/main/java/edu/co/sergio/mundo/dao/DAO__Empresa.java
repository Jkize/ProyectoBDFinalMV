package edu.co.sergio.mundo.dao;


import edu.co.sergio.mundo.vo.Empresa;
import edu.co.sergio.mundo.vo.Sede;
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
public class DAO__Empresa implements DAO<Empresa> {

    private final Connection conexion;

    public DAO__Empresa() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
    }

    @Override
    public List<Empresa> Obtener() throws SQLException {
       List<Empresa> emp = new ArrayList<Empresa>();
        String query = "SELECT * FROM Empresa";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Empresa em = new Empresa(rs.getInt("codigo"), rs.getString("nombre"), new Sede(rs.getString("sede1")));
                emp.add(em);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }
        return emp;
    }
    
    public boolean C(String Nombre, String Sede) throws SQLException {
        String query = " insert into Empresa" + " values (" + Nombre + "," + Sede + ")";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.getString("nombre");
            rs.getString("sede1");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean Crear(Empresa t) throws SQLException {
    boolean result = false;
        String query = " insert into Empresa(nombre,sede1)" + " values (?,?)";
        PreparedStatement Smt = null;
        try {
            Smt = conexion.prepareStatement(query);
            Smt.setString(1, t.getNombre());
            Smt.setString(2, String.valueOf(t.getSede()));
            Smt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;}

    @Override
    public boolean Actualizar(Empresa t) throws SQLException {
    boolean result = false;
        String query = "update Empresa set Nombre = ?, Sede1 = ? where codigo = ?";
        PreparedStatement Smt = null;
        try {
            Smt = conexion.prepareStatement(query);
            Smt.setString(1, t.getNombre());
            Smt.setString(2, String.valueOf(t.getSede()));
            Smt.setInt(3, t.getCodigo());
            if (Smt.executeUpdate() > 0) {
                result = true;
            }
            Smt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;}

    @Override
    public boolean Eliminar(Empresa t) throws SQLException {
    boolean result = false;
        String query = "delete from Empresa where nombre = ?";
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
        return result;}

    
    
    
}
