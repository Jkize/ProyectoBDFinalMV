/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.vo.Categoria;
import edu.co.sergio.mundo.dao.Busqueda;
import edu.co.sergio.mundo.dao.DAO__Categoria;
import edu.co.sergio.mundo.dao.DAO__Empleado;
import edu.co.sergio.mundo.dao.DAO__Empresa;
import edu.co.sergio.mundo.dao.DAO__Sede;
import edu.co.sergio.mundo.dao.DAO__Servidor;
import edu.co.sergio.mundo.vo.Empleado;
import edu.co.sergio.mundo.vo.Empresa;
import edu.co.sergio.mundo.vo.Sede;
import edu.co.sergio.mundo.vo.Servidor;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
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
public class ServletBusquedas extends HttpServlet {

    private DAO__Empresa dao_emp;
    private DAO__Servidor dao_serv;
    private DAO__Categoria dao_cat;
    private DAO__Sede dao_sede;
    private DAO__Empleado dao_emple;
    private Busqueda bus;

    public ServletBusquedas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {

        dao_emp = new DAO__Empresa();
        dao_serv = new DAO__Servidor();
        dao_cat = new DAO__Categoria();
        dao_sede = new DAO__Sede();
        dao_emple = new DAO__Empleado();
        bus = new Busqueda();
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
         RequestDispatcher rq = request.getRequestDispatcher("Busquedas.jsp");

        if (request.getParameter("inicio") != null) {
            List<Object> todo = new ArrayList<Object>();
            List<Empresa> emp = new ArrayList<Empresa>();
            List<Categoria> cat = new ArrayList<Categoria>();
            List<Servidor> servidores = new ArrayList<Servidor>();
            List<Sede> sed = new ArrayList<Sede>();
            List<Empleado> emple = new ArrayList<Empleado>();

            try {
                emp = dao_emp.Obtener();
                servidores = dao_serv.Obtener();
                cat = dao_cat.Obtener();
                sed = dao_sede.Obtener();
                emple = dao_emple.Obtener();

            } catch (SQLException ex) {
                Logger.getLogger(ServletBusquedas.class.getName()).log(Level.SEVERE, null, ex);
            }

            todo.add(emp);
            todo.add(servidores);
            todo.add(cat);
            todo.add(sed);
            todo.add(emple);

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
         RequestDispatcher rq = request.getRequestDispatcher("Busquedas.jsp");

        if (request.getParameter("consulta") != null) {

            List<Object> todo = new ArrayList<Object>();
            List<Empresa> emp = new ArrayList<Empresa>();
            List<Categoria> cat = new ArrayList<Categoria>();
            List<Servidor> servidores = new ArrayList<Servidor>();
            List<Sede> sed = new ArrayList<Sede>();
            List<Empleado> emple = new ArrayList<Empleado>();

            try {
                emp = dao_emp.Obtener();
                servidores = dao_serv.Obtener();
                cat = dao_cat.Obtener();
                sed = dao_sede.Obtener();
                emple = dao_emple.Obtener();

            } catch (SQLException ex) {
                Logger.getLogger(ServletBusquedas.class.getName()).log(Level.SEVERE, null, ex);
            }

            todo.add(emp);
            todo.add(servidores);
            todo.add(cat);
            todo.add(sed);
            todo.add(emple);

            String empresa = request.getParameter("Empresa");
            String aux1[] = empresa.split(" ");

            String sede = request.getParameter("Sede");
            String servidor = request.getParameter("Servidor");
            String aux2[] = servidor.split(" ");

            String categoria = request.getParameter("Categoria");
            String aux3[] = categoria.split(" ");

            String fecha = request.getParameter("fecha1");

            String operador = request.getParameter("Operador");
            String aux4[] = operador.split(" ");

            StringJoiner Query = new StringJoiner(" AND ");

            System.out.println(empresa + " " + sede + " " + servidor + " " + categoria + " " + fecha + " " + operador);

            if (empresa.length() != 0) {
                Query.add("Empresa.Codigo=" + String.valueOf(aux1[0]));
            }

            if (sede.length() != 0) {
                Query.add("Sede.Codigo='" + sede + "'");
            }

            if (servidor.length() != 0) {
                Query.add("Servidor.Codigo=" + aux2[0]);
            }

            if (fecha.length() != 0) {

                // Query.add(""+fecha+"'");
            }

            if (categoria.length() != 0) {
                Query.add("Categoria.Codigo=" + aux3[0]);
            }

            if (operador.length() != 0) {
                Query.add("Empleado.Correo='" + aux4[0] + "'");
            }

            List<String> filtros = bus.Filter("Where " + Query.toString());
            
            todo.add(filtros);
            
            request.setAttribute("todo", todo);
            rq.forward(request, response);

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
