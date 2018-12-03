/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.DAO__Empresa;
import edu.co.sergio.mundo.vo.Empresa;
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
public class ServletEmpresas extends HttpServlet {
  DAO__Empresa daoEmpresa;

    @Override
    public void init() throws ServletException {
        try {
            this.daoEmpresa = new DAO__Empresa();
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
          Logger.getLogger(ServletEmpresas.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    

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
        RequestDispatcher rq = request.getRequestDispatcher("Empresas.jsp");
        List<Empresa> emp = new ArrayList<Empresa>();
        try {
            emp = daoEmpresa.Obtener();
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaEmpresas", emp);
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
      RequestDispatcher rq = request.getRequestDispatcher("Empresas.jsp");
        if (request.getParameter("buscar") != null) {
            int codigo = 0;
            String nombre = null;
            String sede = null;
            try {
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                sede = request.getParameter("sede");
                Empresa emp = new Empresa();
                emp.setCodigo(codigo);
                emp.setNombre(nombre);
                emp.setSede(new Sede(sede));
                List<Empresa> empresas = daoEmpresa.Obtener();
                Empresa empresita = empresas.get(empresas.indexOf(emp));
                if (empresita != null) {
                    request.setAttribute("empresaEncontrada", empresita);
                } else {
                    System.out.println("No se encontró empresa.");
                }
            } catch (Exception e) {

            }
        } else if (request.getParameter("ingresar") != null) {
            int codigo = 0;
            String nombre = null;
            String sede = null;
            try {
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                sede = request.getParameter("sede");
                Empresa emp = new Empresa();
                emp.setCodigo(codigo);
                emp.setNombre(nombre);
                emp.setSede(new Sede(sede));
                if (!daoEmpresa.Crear(emp)) {
                    System.out.println("Error Creando.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (request.getParameter("actualizar") != null) {
            int codigo = 0;
            String nombre = null;
            String sede = null;
            try {
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                sede = request.getParameter("sede");
                Empresa emp = new Empresa();
                emp.setCodigo(codigo);
                emp.setNombre(nombre);
                emp.setSede(new Sede(sede));
                if (!daoEmpresa.Actualizar(emp)) {
                    System.out.println("Error Actualizando");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {//Eliminar
            int codigo = 0;
            String nombre = null;
            String sede = null;
            try {
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                sede = request.getParameter("sede");
                Empresa emp = new Empresa();
                emp.setCodigo(codigo);
                emp.setNombre(nombre);
                emp.setSede(new Sede(sede));
                if (!daoEmpresa.Eliminar(emp)) {
                    System.out.println("Error Eliminando.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        rq.forward(request, response);
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
