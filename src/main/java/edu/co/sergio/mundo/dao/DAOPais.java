/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

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
public class DAOPais {

    public List<Pais> findAllByEscuela() {
        List<Pais> paises = new ArrayList<Pais>();
        String query = "SELECT * FROM Pais;";
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

                Pais pais = new Pais(rs.getInt("codigo"), rs.getString("nombrePais"));

                paises.add(pais);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return paises;

    }
}
