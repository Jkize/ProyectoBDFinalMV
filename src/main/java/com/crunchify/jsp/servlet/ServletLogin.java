/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.DAO__Empleado;
import edu.co.sergio.mundo.vo.Empleado;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhoan Saavedra
 */
public class ServletLogin extends HttpServlet {

      private DAO__Empleado daoEmpleado;

    public ServletLogin() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        daoEmpleado = new DAO__Empleado();
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
        RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
        HttpSession sesionEmpleado = request.getSession();
        Empleado _sesionEmpleado;
        if (request.getParameter("idEmpleado") != null) {
            if (request.getParameter("Admin") != null) {
                _sesionEmpleado = (Empleado) sesionEmpleado.getAttribute("Admin");
            } else {
                _sesionEmpleado = (Empleado) sesionEmpleado.getAttribute("Operario");
            }
            if (_sesionEmpleado != null) {
                System.out.println(_sesionEmpleado.getCorreo());
                if (_sesionEmpleado.getCorreo().equals(request.getParameter("idEmpleado"))) {
                    sesionEmpleado.invalidate();
                }
            }
        }
        if (request.getParameter("error") != null) {
            request.setAttribute("error", "si");
        }
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
         String idPersona = request.getParameter("form-username");
        String pass = request.getParameter("form-password");
        System.out.println(idPersona+" "+pass);
        try {
            if (idPersona.length() > 0 && pass.length() > 0) {
                Empleado a = new Empleado();
                a.setCorreo(idPersona);
                a.setContrasena(pass);
                
                a = daoEmpleado.usuarioValido(a);
                System.out.println(a.getNombre());
                HttpSession sesionEmpleado = request.getSession();
                Empleado _sesionEmpleado = (Empleado) sesionEmpleado.getAttribute("Empleado");
                if (_sesionEmpleado == null) {
                    //El usuario no a creado la sesion
                    if (a != null) {
                        if (a.getCargo().equals("AD")) {
                            sesionEmpleado.setAttribute("Admin", a);
                            sesionEmpleado.setMaxInactiveInterval(60 * 2);
                            response.sendRedirect("ServletAdministrador?idEmpleado=" + String.valueOf(a.getCorreo()));

                            //REDIRIGIMOS AL ADMINISTRADOR
                        } else {
                            sesionEmpleado.setAttribute("Operario", a);
                            sesionEmpleado.setMaxInactiveInterval(60 * 2);
                            response.sendRedirect("ServletActividadOp?idEmpleado=" + String.valueOf(a.getCorreo()));
                            //REDIRIGIMOS AL EMPLEADO 
                        }

                    } else {
                        //VOTAMOS MENSAJE DE ERROR
                         response.sendRedirect("ServletLogin?error=Si");
                           
                    }

                } else {
                    if (a != null) {
                         if (a.getCargo().equals("AD")) {
                            sesionEmpleado.setAttribute("Admin", a);
                            sesionEmpleado.setMaxInactiveInterval(60 * 2);
                            response.sendRedirect("ServletAdministrador?idEmpleado=" + String.valueOf(a.getCorreo()));

                            //REDIRIGIMOS AL ADMINISTRADOR
                        } else {
                            sesionEmpleado.setAttribute("Operario", a);
                            sesionEmpleado.setMaxInactiveInterval(60 * 2);
                            response.sendRedirect("ServletActividadOp?idEmpleado=" + String.valueOf(a.getCorreo()));
                            //REDIRIGIMOS AL EMPLEADO 
                        }

                    } else {
                        
                         response.sendRedirect("ServletLogin?error=Si");
                    }
                }
                
            } else {
                
                         response.sendRedirect("ServletLogin?error=Si");
            }
        }catch (NumberFormatException ex) {
            response.sendRedirect("ServletLogin?error=Si");
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
