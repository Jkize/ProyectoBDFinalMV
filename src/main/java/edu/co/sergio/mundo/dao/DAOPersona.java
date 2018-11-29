/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Persona;
import edu.co.sergio.mundo.vo.Pais;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAOPersona {

    public boolean crear(Persona ob) throws SQLException {
        boolean result = false;
        String query = "insert into Persona values (?,?,?,?,?,?,?)";

        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, ob.getIdentidad());
            preparedStmt.setString(2, ob.getNombre());
            preparedStmt.setString(3, ob.getApellido());
            java.sql.Date fechaSQL = new java.sql.Date(ob.getFecha_nac().getTime());

            preparedStmt.setDate(4, fechaSQL);
            preparedStmt.setString(5, ob.getSexo());
            preparedStmt.setInt(6, ob.getPais().getId());
            preparedStmt.setString(7, ob.getDescripcion());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }
            preparedStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public List<Persona> obPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        String query = "SELECT * FROM Persona JOIN Pais on(Persona.pais=Pais.codigo);";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement preparedStmt = null;
            preparedStmt = connection.prepareStatement(query);
            // preparedStmt.setInt (1, codEscuela);
            ResultSet rs = preparedStmt.executeQuery();
            int id = 0;
            String nombre = null, escuela = null;

            while (rs.next()) {
                Persona persona = new Persona(rs.getInt("identidad"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getDate("fecha_N"), rs.getString("sexo"), new Pais(rs.getInt("pais")), rs.getString("descripcion"));
                persona.getPais().setNombre(rs.getString("nombrePais"));

                personas.add(persona);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Estudiantes");
            e.printStackTrace();
        }

        return personas;

    }
}
