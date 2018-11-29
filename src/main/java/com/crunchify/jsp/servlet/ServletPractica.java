/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.DAOEstudiante;
import edu.co.sergio.mundo.dao.DAOPais;
import edu.co.sergio.mundo.dao.DAOPersona; 
import edu.co.sergio.mundo.vo.Pais;
import edu.co.sergio.mundo.vo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ServletPractica extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("ENTRO al DOGET");
        DAOPais daopais = new DAOPais();
        List<Pais> paises = daopais.findAllByEscuela();
        request.setAttribute("paises", paises);

        System.out.println("Tamaño del Arreglo "+paises.size());
        RequestDispatcher redireccion = request.getRequestDispatcher("practica.jsp");
        redireccion.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        DAOEstudiante daoEstudiante = new DAOEstudiante();
        String BRegistrar = request.getParameter("BRegistrar");
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fecha = request.getParameter("fecha");
        String sexo = request.getParameter("sexo");
        String pais = request.getParameter("pais");

        String descripcion = request.getParameter("descripcion");
        
        System.out.println("ENTRO AL POST");
        if (BRegistrar != null) {
            System.out.println("ENTRO al boton");
            try {
                Persona persona = new Persona(Integer.parseInt(id), nombre, apellido, new Date(Long.parseLong(fecha)), sexo, new Pais(Integer.parseInt(pais)), descripcion);
                DAOPersona daoPe = new DAOPersona();

                if (daoPe.crear(persona)) {
                    List<Persona> personas = daoPe.obPersonas();

                    JSONObject jsonOb = new JSONObject();

                    JSONArray matrix = new JSONArray();
                    for (Persona per : personas) {
                        JSONArray fila = new JSONArray();
                        fila.put(per.getIdentidad());
                        fila.put(per.getNombre());
                        fila.put(per.getApellido());
                        fila.put(per.getFecha_nac());
                        fila.put(per.getSexo());
                        fila.put(per.getPais().getNombre());
                        fila.put(per.getDescripcion());
                        matrix.put(fila);
                    }
                    jsonOb.put("dat", matrix);
                    String h = "[{\"title\":\"Identificacion\"},{\"title\":\"Nombre\"},{\"title\":\"Apellido\"},{\"title\":\"fecha Nacimiento\"},{\"title\":\"Sexo\"},{\"title\":\"Pais\"},{\"title\":\"Descripcion\"}] ";

                    jsonOb.put("col", new JSONObject(h));
                    out.println(jsonOb);

                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletEscuela.class.getName()).log(Level.SEVERE, null, ex);

            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }

    }
}
