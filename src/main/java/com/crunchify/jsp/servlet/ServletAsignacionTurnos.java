/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.DAO__Sede;
import edu.co.sergio.mundo.dao.Turnos;
import edu.co.sergio.mundo.vo.Empleado;
import edu.co.sergio.mundo.vo.Sede;
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
 * @author Jhoan Saavedra
 */
public class ServletAsignacionTurnos extends HttpServlet {

    private DAO__Sede dao;
    private Turnos daoTur;

    @Override
    public void init() throws ServletException {
        try {
            this.dao = new DAO__Sede();
            this.daoTur = new Turnos();
        } catch (SQLException ex) {
            Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        RequestDispatcher rq = request.getRequestDispatcher("AsignacionTurnos.jsp");
        List<Sede> emp = new ArrayList<Sede>();
        try {
            emp = dao.Obtener();
        } catch (SQLException ex) {
            Logger.getLogger(ServletActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaSedes", emp);

        rq.forward(request, response);

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
        RequestDispatcher rq = request.getRequestDispatcher("AsignacionTurnos.jsp");
        if (request.getParameter("Buscar") != null) {
            String sede = request.getParameter("Sede");
            List<Empleado> emp = new ArrayList<Empleado>();
            try {
                emp = daoTur.TenerTurnos(sede);
            } catch (SQLException ex) {
                Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("listaEmpleados", emp);

            List<Sede> sed = new ArrayList<Sede>();
            try {
                sed = dao.Obtener();
            } catch (SQLException ex) {
                Logger.getLogger(ServletActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("listaSedes", sed);

            rq.forward(request, response);

        }

        if (request.getParameter("Asignar") != null) {

            List<Sede> sed = new ArrayList<Sede>();
            try {
                sed = dao.Obtener();
            } catch (SQLException ex) {
                Logger.getLogger(ServletActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("listaSedes", sed);
            
            if (!request.getParameter("TurnoManana").equals("Seleccione operador") && !request.getParameter("TurnoTarde1").equals("Seleccione operador")
                    && !request.getParameter("TurnoTarde2").equals("Seleccione operador") && !request.getParameter("TurnoNoche").equals("Seleccione operador")) {
                
                List<Empleado> turnosNuevos = new ArrayList<Empleado>();
                Empleado emp11 = new Empleado();
                emp11.setCorreo(request.getParameter("TurnoManana"));
                emp11.setTurno("A");
                System.out.println(emp11.getCorreo()+" "+emp11.getTurno());
                turnosNuevos.add(emp11);
                Empleado emp12 = new Empleado();
                emp12.setCorreo(request.getParameter("TurnoTarde1"));
                emp12.setTurno("B");
                 System.out.println(emp12.getCorreo()+" "+emp12.getTurno());
                turnosNuevos.add(emp12);
                Empleado emp13 = new Empleado();
                emp13.setCorreo(request.getParameter("TurnoTarde2"));
                emp13.setTurno("C");
                 System.out.println(emp13.getCorreo()+" "+emp13.getTurno());
                turnosNuevos.add(emp13);
                Empleado emp14 = new Empleado();
                emp14.setCorreo(request.getParameter("TurnoNoche"));
                emp14.setTurno("D");
                 System.out.println(emp14.getCorreo()+" "+emp14.getTurno());
                turnosNuevos.add(emp14);
                try {
                    daoTur.InsertarTurnos(turnosNuevos);
                } catch (SQLException ex) {
                    Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ServletAsignacionTurnos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             rq.forward(request, response);

        }

        response.sendRedirect("ServlectAsignacionTurnos");
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
