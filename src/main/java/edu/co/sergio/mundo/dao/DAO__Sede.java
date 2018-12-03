package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Sede;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author 
 * @since 
 * 
 */

public class DAO__Sede implements DAO<Sede>{

    private final Connection conexion;

    public DAO__Sede() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
    }
  
    @Override
    public List<Sede> Obtener() throws SQLException {
	 List<Sede> sedes = new ArrayList<Sede>();
        String query = "SELECT * FROM Sede";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Sede em=new Sede(); 
                em.setCodigo(rs.getString("codigo"));
                sedes.add(em);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return sedes;
    }

    public Sede Buscar(String codigo) throws SQLException {
        Sede sede = null;
        String query = "SELECT * FROM Sede WHERE codigo=" + codigo;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                sede = new Sede();
                sede.setCodigo(rs.getString("codigo"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return sede;

    }
    @Override
    public boolean Crear(Sede t) throws SQLException {
        boolean result=false;
        try {
            
            Connection conexion = Conexion.getConnection();
            String query = " insert into Sede"  + " values (?)";
            PreparedStatement preparedStmt=null;
            try {
                preparedStmt = conexion.prepareStatement(query);
                preparedStmt.setString(1, t.getCodigo());
                if (preparedStmt.executeUpdate() > 0){
                    result=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            } catch (URISyntaxException ex) {
            Logger.getLogger(DAO__Sede.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result;
}

    @Override
    public boolean Actualizar(Sede t) throws SQLException {
	 boolean result=false;
         String query =
                 "update Sede set codigo = ? where codigo = ?";
         PreparedStatement preparedStmt=null;
         try {
             preparedStmt = conexion.prepareStatement(query);
             preparedStmt.setString(1, t.getCodigo());
             preparedStmt.setString(2, t.getCodigo());
             
             if (preparedStmt.executeUpdate() > 0){
                 result=true;
             }
             
         } catch (SQLException e) {
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public boolean Eliminar(Sede t) throws SQLException {
	 boolean result=false;
         String query = "delete from Persona where cedula = ?";
         PreparedStatement preparedStmt=null;
         try {
             preparedStmt = conexion.prepareStatement(query);
             preparedStmt.setString(1, t.getCodigo());
             result= preparedStmt.execute();
         } catch (SQLException e) {
             e.printStackTrace();
         }
        return result; 
}
    
}
