/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.vo.Actividad;
import edu.co.sergio.mundo.vo.Categoria;
import edu.co.sergio.mundo.dao.DAO__Actividad;
import edu.co.sergio.mundo.dao.DAO__Empresa;
import edu.co.sergio.mundo.vo.Empresa;
import edu.co.sergio.mundo.vo.Servidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author katemorales
 */
public class ServletCargaMActividades extends HttpServlet {
 private DAO__Empresa dao_emp;
    private DAO__Actividad dao_act;

    public ServletCargaMActividades() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        dao_emp = new DAO__Empresa();
        dao_act = new DAO__Actividad();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher rq = request.getRequestDispatcher("CargaMActividades.jsp");

        if (request.getParameter("inicio") != null) {
            List<Object> todo = new ArrayList<Object>();
            List<Empresa> emp = new ArrayList<Empresa>();

            try {
                emp = dao_emp.Obtener();

            } catch (SQLException ex) {
                Logger.getLogger(ServletBusquedas.class.getName()).log(Level.SEVERE, null, ex);
            }

            todo.add(emp);

            request.setAttribute("todo", todo);
            rq.forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher rq = request.getRequestDispatcher("CargaMActividades.jsp");

        ArrayList<Actividad> obs = new ArrayList<Actividad>();

        String array = request.getParameter("data");
        String cols = request.getParameter("cols");
        String empre = request.getParameter("empresa");

        String aux2[] = empre.split(" ");
        String aux[] = array.split(" ");

        //QUE SE VA A INGRESAR EN EL BASE DE DATOS
        String query = "INSERT INTO Actividad(";

        for (int i = 0; i <= Integer.parseInt(cols); i++) {

            if (i == Integer.parseInt(cols)) {
                query = query.substring(0, query.length() - 1);
                query += ",Empresa1)";
            } else {
                if (aux[i].trim().equalsIgnoreCase("")) {

                } else {
                    query += aux[i].trim() + ",";
                }

            }

        }

        System.out.println(query);
        System.out.println(cols + "  columnas");
        System.out.println(aux.length);

        //CREAR ARRAY DE ACTIVIDADES
        Actividad a = new Actividad();
        a.setEmpresa(new Empresa(Integer.parseInt(aux2[0])));
        int b = 1;

        for (int i = 12; i < aux.length; i++) {

            String data = aux[i].trim();
            
            if (b == 12) {
                b = 1;
                a.setDescripcion(data);
                obs.add(a);
                a = new Actividad();
                a.setEmpresa(new Empresa(Integer.parseInt(aux2[0])));
            } else {

                if (data.equalsIgnoreCase("undefined")) {
                    data = null;
                }

                System.out.println(data);
                System.out.println(b);

                try {
                    switch (b) {

                        case 1:

                            a.setNombre(data);
                            break;
                        case 2:
                            a.setEjecucion(data);
                            break;
                        case 3:

                            if (data == null) {

                            } else {
                                a.setIntervaloTiempo(Integer.parseInt(data));
                            }

                            break;
                        case 4:
                            a.setHoraInicio(data);
                            break;
                        case 5:

                            if (data == null) {

                            } else {
                                a.setNroVecesDia(Integer.parseInt(data));
                            }

                            break;
                        case 6:

                            a.setFechaEspecifica(data);

                            break;
                        case 7:

                            a.setURLManual(data);

                            break;
                        case 8:

                            a.setURLVideo(data);

                            break;
                        case 9:

                            a.setServidor(new Servidor(Integer.parseInt(data)));

                            break;
                        case 10:

                            if (data == null) {

                            } else {
                                a.setCategoria(new Categoria(Integer.parseInt(data)));
                            }

                            break;
                        case 11:

                            if (data == null) {

                            } else {
                                a.setDuracionEst(Integer.parseInt(data));
                            }

                            break;
                     

                    }
                } catch (Exception e) {

                }

                b++;

            }

        }

        //INGRESANDO DATOS - HORA DE LA VERDAD 
        for (int i = 0; i < obs.size(); i++) {

            try {
                dao_act.Crear2(obs.get(i), query);
            } catch (SQLException ex) {
                Logger.getLogger(ServletCargaMActividades.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
