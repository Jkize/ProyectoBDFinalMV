package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.*;
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
 * @author 
 * @since 
 * 
 */

public class DAO__Empleado implements DAO<Empleado>{

    private final Connection conexion;
    private DAO__Sede daosed;
    
    public DAO__Empleado() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
        daosed= new DAO__Sede();
    }
    
    @Override
    public List<Empleado> Obtener() throws SQLException {
    List<Empleado> empleados = null;
        String query = "SELECT * FROM Empleado WHERE Cargo='OP'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            String correo = null, nombre = null, contrasena = null, cargo = null;
            String correoPlanta = null, fechaI = null, fechaF = null, turno = null;
            String sede = null;
            while (rs.next()) {
                if (empleados == null) {
                    empleados = new ArrayList<Empleado>();
                }
                Empleado empleado = new Empleado();
                
                correo = rs.getString("correo");
                empleado.setCorreo(correo);
                nombre = rs.getString("Nombre");
                empleado.setNombre(nombre);
                contrasena = rs.getString("Contrasena");
                empleado.setContrasena(contrasena);
                cargo = rs.getString("Cargo");
                empleado.setCargo(cargo);
                sede = rs.getString("Sede1");
                empleado.setSede(new Sede(sede));
                
                empleados.add(empleado);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados.");
            e.printStackTrace();
        }

        return empleados;}

    public Empleado Buscar(String correo) throws SQLException {
        Empleado emple = null;
        String query = "SELECT * FROM Empleado WHERE correo=" + correo;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                emple = new Empleado();
                emple.setCorreo(rs.getString("correo"));
                emple.setNombre(rs.getString("Nombre"));
                emple.setSede(daosed.Buscar(rs.getString("Nombre")));
                emple.setTurno(rs.getString("Turno"));
                emple.setContrasena(rs.getString("Contrasena"));
                emple.setCargo(rs.getString("Cargo"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return emple;

    }
    
    public Empleado usuarioValido(Empleado empleado) throws ClassNotFoundException {
        System.out.println(empleado.getCorreo()+" "+empleado.getContrasena());
        Empleado emp = null;
        try {
            PreparedStatement Smt = conexion.prepareStatement("select * from Empleado where correo=? AND contrasena=?");
            Smt.setString(1, empleado.getCorreo());
            Smt.setString(2, empleado.getContrasena());
            ResultSet rs = Smt.executeQuery();
            if (rs.next()) {
                System.out.println("Entra a validar USUARIO1");
                emp = new Empleado();
                emp.setCorreo(rs.getString("correo"));
                emp.setContrasena(rs.getString("contrasena"));
                emp.setCargo(rs.getString("cargo"));
                emp.setNombre(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;

    }
    
    @Override
    public boolean Crear(Empleado t) throws SQLException {
   boolean result=false;
        String query = " insert into Empleado (correo,Nombre,Contrasena,Cargo,Turno,Sede1) values (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
	    preparedStmt.setString(1, t.getCorreo());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setString(3, t.getContrasena());
            preparedStmt.setString(4, t.getCargo());
            preparedStmt.setString(5, null);
            preparedStmt.setString(6, t.getSede().getCodigo());
            
	    result= preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
	}
	return result;}

    @Override
    public boolean Actualizar(Empleado t) throws SQLException {
    boolean result=false;
	String query = "update Persona set correo = ?, Nombre = ?, Contrasena=?, Cargo=?, Sede1=? where correo = ?";
	PreparedStatement preparedStmt=null;
        try {
	    preparedStmt = conexion.prepareStatement(query);
	    preparedStmt.setString(1, t.getCorreo());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setString(3, t.getContrasena());
            preparedStmt.setString(4, t.getCargo());
            preparedStmt.setString(5, t.getSede().getCodigo());
            preparedStmt.setString(6, t.getCorreo());
                    
	    if (preparedStmt.executeUpdate() > 0){
	   	result=true;
	    }
			    
	} catch (SQLException e) {
		e.printStackTrace();
	}
        
        return result;
    }

    @Override
    public boolean Eliminar(Empleado t) throws SQLException {
     boolean result=false;
        String query = "delete from Empleado where correo = ?";
        PreparedStatement preparedStmt=null;
	 try {
	    preparedStmt = conexion.prepareStatement(query);
	    preparedStmt.setString(1, t.getCorreo());
	    result= preparedStmt.execute();
	} catch (SQLException e) {
	  e.printStackTrace();
	}
	return result;
    }
    
}
