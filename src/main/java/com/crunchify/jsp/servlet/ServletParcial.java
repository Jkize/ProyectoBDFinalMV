/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.DAOExercises;
import edu.co.sergio.mundo.vo.Exercise;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author Jhoan Saavedra
 */
public class ServletParcial extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ENTRO al DOGET");
        DAOExercises daoExer = new DAOExercises();
        List<Exercise> topics = daoExer.findNames();

        request.setAttribute("topic", topics);
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("parcial.jsp");
        redireccion.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String topic = request.getParameter("topic");

        System.out.println("ENTRO AL POST");
        if (topic != null) {
            System.out.println("ENTRO al boton");
            try {

                DAOExercises daoExer = new DAOExercises();
                System.out.println(topic);
                List<Exercise> topics = daoExer.findAllByEscuela(topic);
                System.out.println("Tamaño Arreglo "+topics.size());
                
                JSONObject jsonOb = new JSONObject();
                JSONArray matrix = new JSONArray();
                for (Exercise exer : topics) {
                    JSONArray fila = new JSONArray();
                    fila.put(exer.getCat() + "");
                    fila.put(exer.getEno());
                    fila.put(exer.getProm());
                    matrix.put(fila);
                }
                jsonOb.put("dat", matrix);
                String h = "{ \"col2\":  [{\"title\":\"CAT\"},{\"title\":\"ENO\"},{\"title\":\"PROMEDIO\"}]} ";

                jsonOb.put("col", new JSONObject(h));
                out.println(jsonOb);

            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }

    }
}
