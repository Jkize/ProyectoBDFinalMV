/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Exercise;
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
 * @author Labing
 */
public class DAOExercises {

    public List<Exercise> findAllByEscuela(String name) {
        List<Exercise> exercises = new ArrayList<Exercise>();
        String query = "SELECT RESULTS.CAT AS CAT, RESULTS.ENO AS ENO, ROUND(AVG(RESULTS.POINTS),2) AS ROUNDED FROM RESULTS,(SELECT CAT,ENO FROM Exercises WHERE TOPIC='"+name+"')AS T WHERE T.CAT=RESULTS.CAT AND T.ENO=RESULTS.ENO GROUP BY (RESULTS.CAT,RESULTS.ENO);";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;

            while (rs.next()) {
                Exercise ex = new Exercise(rs.getString("CAT").charAt(0), rs.getInt("ENO"), name, rs.getDouble("ROUNDED"));
                exercises.add(ex);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return exercises;

    }

    public List<Exercise> findNames() {
        List<Exercise> tareas = new ArrayList<Exercise>();
        String query = "SELECT DISTINCT TOPIC FROM Exercises;";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String nombre = null;

            while (rs.next()) {
                Exercise tarea = new Exercise();
                tarea.setTopic(rs.getString("TOPIC"));
                tareas.add(tarea);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return tareas;

    }

}
