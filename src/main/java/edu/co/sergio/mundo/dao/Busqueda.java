/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kathe
 */
public class Busqueda implements Serializable{
    
     private final Connection conexion;
    
    public Busqueda() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException{
        conexion=Conexion.getConnection();
    }
    
    public List<String> Filter(String query){
        
        List<String> Busquedas = new ArrayList<String>();
        String queryFinal = "SELECT Seguimiento.Codigo, Descripcion, Correo, Estado, Seguimiento.HoraInicio, Seguimiento.HoraFin, Seguimiento.Observaciones FROM SEGUIMIENTO JOIN Actividad ON (Seguimiento.Actividad1=Actividad.Codigo) JOIN Empleado ON (Seguimiento.Empleado1=Empleado.Correo) JOIN Servidor ON (Actividad.Servidor1=Servidor.Codigo) JOIN Categoria ON (Actividad.Categoria1=Categoria.Codigo) JOIN Empresa ON (Actividad.Empresa1=Empresa.Codigo) JOIN Sede ON (Empresa.Sede1=Sede.Codigo)" + query;
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(queryFinal);
            
            int codigo=0;
            String descripcion="", correo="", estado="", HoraInicio="", HoraFin="", Observaciones="";
            StringJoiner aux = new StringJoiner(",");
            
            while (rs.next()) {
            
              codigo=rs.getInt("Codigo");
              aux.add(String.valueOf(codigo));
              descripcion=rs.getString("Descripcion");
              aux.add(descripcion);
              correo=rs.getString("correo");
              aux.add(correo);
              estado=rs.getString("estado");
              aux.add(estado);
              HoraInicio=rs.getString("HoraInicio");
              aux.add(HoraInicio);
              HoraFin=rs.getString("HoraFin");
              aux.add(HoraFin);
              Observaciones=rs.getString("Observaciones");
              aux.add(Observaciones);
                
              Busquedas.add(aux.toString());
              aux = new StringJoiner(",");
              
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }
        
        
        return Busquedas;
    }
}
