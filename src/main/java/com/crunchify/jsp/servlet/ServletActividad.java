/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.vo.Actividad;
import edu.co.sergio.mundo.dao.DAO__Empresa;
import edu.co.sergio.mundo.dao.DAO__Servidor;
import edu.co.sergio.mundo.dao.DAO__Categoria;
import edu.co.sergio.mundo.vo.Empresa;
import edu.co.sergio.mundo.vo.Servidor;
import edu.co.sergio.mundo.vo.Categoria;
import edu.co.sergio.mundo.dao.DAO__Actividad;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhoan Saavedra
 */
public class ServletActividad extends HttpServlet {

    private DAO__Empresa dao_emp;
    private DAO__Servidor dao_serv;
    private DAO__Categoria dao_cat;
    private DAO__Actividad dao_acti;

    public ServletActividad() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        dao_emp = new DAO__Empresa();
        dao_cat = new DAO__Categoria();
        dao_serv = new DAO__Servidor();
        dao_acti = new DAO__Actividad();
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

        RequestDispatcher rq = request.getRequestDispatcher("Actividades.jsp");
        List<Object> todo = new ArrayList<Object>();
        //if (request.getParameter("inicio") != null) {
        try {
            todo = obtenertodo();
            request.setAttribute("todo", todo);
            rq.forward(request, response);
        } catch (SQLException e) {
             
            List<Empresa> emp = new ArrayList<Empresa>();
            List<Categoria> cat = new ArrayList<Categoria>();
            List<Servidor> servidores = new ArrayList<Servidor>();
            List<Actividad> act = new ArrayList<Actividad>();
            todo.add(emp);
            todo.add(cat);
            todo.add(servidores);
            todo.add(act);
            todo.add("Error de Conexión SQL");
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
        RequestDispatcher rq = request.getRequestDispatcher("Actividades.jsp");
        List<Object> todo = new ArrayList<Object>();
        try {
            todo = obtenertodo();
            if (request.getParameter("registrar") != null) {

                try {
                    registro(request, todo, "registro", 0);
                    List<Actividad> actividades = this.dao_acti.Obtener();
                    todo.set(3, actividades);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (java.lang.NumberFormatException e) {
                    todo.add("Error de Castear Entero");
                    e.printStackTrace();
                }
                request.setAttribute("todo", todo);
                rq.forward(request, response);

            }

            if (request.getParameter("actualizar") != null) {

                String codigo = request.getParameter("codigoBAE");

                try {
                    if (codigo.length() != 0 && codigo != null) {
                        int cod = Integer.parseInt(codigo);
                        try {
                            registro(request, todo, "", cod);
                            List<Actividad> actividades = this.dao_acti.Obtener();
                            todo.set(3, actividades);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (java.lang.NumberFormatException e) {
                            todo.add("Error de Castear Entero");
                            e.printStackTrace();
                        }
                    } else {
                        todo.add("Error Datos Actividad-Codigo a buscar vacio");
                    }
                } catch (java.lang.NumberFormatException e) {
                    todo.add("Error dato invalido, debe ser entero");
                }

                request.setAttribute("todo", todo);
                rq.forward(request, response);
            }

            if (request.getParameter("buscar") != null) {

                String codigo = request.getParameter("codigoBAE");
                System.out.println("El codigo BAE es " + codigo);
                try {
                    if (codigo.length() != 0 && codigo != null) {
                        int cod = Integer.parseInt(codigo);
                        Actividad act = this.dao_acti.buscar(cod);
                        if (act != null) {
                            todo.add("OK Se encontro perfectamente");
                            todo.add(act);
                        } else {
                            todo.add("Warning No se encontro");
                        }

                    } else {
                        todo.add("Error Datos Actividad-Codigo a buscar vacio");
                    }

                } catch (java.lang.NumberFormatException e) {
                    todo.add("Error dato invalido, debe ser entero");
                }

                request.setAttribute("todo", todo);
                rq.forward(request, response);

            }

            if (request.getParameter("eliminar") != null) {
                String codigo = request.getParameter("codigoBAE");
                try {
                    if (codigo.length() != 0) {
                        int cod = Integer.parseInt(codigo);
                        Actividad act = new Actividad(cod);
                        if (this.dao_acti.Eliminar(act)) {
                            todo.add("OK Se elimino correctamente");
                        } else {
                            todo.add("Warning No se encontro");
                        }

                    } else {
                        todo.add("Error Datos Actividad-Codigo a buscar vacio");
                    }

                } catch (java.lang.NumberFormatException e) {
                    todo.add("Error dato invalido, debe ser entero");
                }

                request.setAttribute("todo", todo);
                rq.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            List<Empresa> emp = new ArrayList<Empresa>();
            List<Categoria> cat = new ArrayList<Categoria>();
            List<Servidor> servidores = new ArrayList<Servidor>();
            List<Actividad> act = new ArrayList<Actividad>();
            todo.add(emp);
            todo.add(cat);
            todo.add(servidores);
            todo.add(act);
            todo.add("Error de Conexión SQL");
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

    private void registro(HttpServletRequest request, List<Object> todo, String met, int cod) throws SQLException {
        String empresa = request.getParameter("empresa");
        String categoria = request.getParameter("categoria");
        String servidor = request.getParameter("servidor");
        String ejecucionRadio = request.getParameter("group5");
        String nombre = request.getParameter("nombre").trim();
        String intervalotiempo = request.getParameter("intervalotiempo").trim();
        String horaInicio = request.getParameter("horainicio").trim();
        String nroveces = request.getParameter("vecesdeldia").trim();
        StringJoiner ejecucion = new StringJoiner("-");
         
        String fecha = request.getParameter("fecha1");
        String descripcion = request.getParameter("destarea").trim();
        String URLManual = request.getParameter("manualarea").trim();
        String URLVideo = request.getParameter("expliarea").trim();

        String duracionEst = request.getParameter("durest");

        int cont = 0;
        if (ejecucionRadio != null) {
            ejecucion.add(ejecucionRadio);
            cont++;
        }

        if (request.getParameter("Lu") != null) {
            ejecucion.add("Lu");
            cont++;
        }
        if (request.getParameter("Ma") != null) {
            ejecucion.add("Ma");
            cont++;
        }
        if (request.getParameter("Mi") != null) {
            ejecucion.add("Mi");
            cont++;
        }
        if (request.getParameter("Ju") != null) {
            ejecucion.add("Ju");
            cont++;
        }
        if (request.getParameter("Vi") != null) {
            ejecucion.add("Vi");
            cont++;
        }
        if (request.getParameter("Sa") != null) {
            ejecucion.add("Sa");
            cont++;
        }
        if (request.getParameter("Do") != null) {
            ejecucion.add("Do");
            cont++;
        }
        if (request.getParameter("Fe") != null) {
            ejecucion.add("Fe");
            cont++;
        }
        if (nombre.length() != 0 && duracionEst.length() != 0 && cont > 0 && empresa.length()!=0 && servidor.length()!=0 && categoria.length()!=0 && intervalotiempo.length() != 0 && horaInicio.length() != 0) {

            int codEmp = Integer.parseInt(empresa);
            
            int codServ = Integer.parseInt(servidor);
            
            int codCat = Integer.parseInt(categoria);
            int intervalo = Integer.parseInt(intervalotiempo);
            int numveces = Integer.parseInt(nroveces);
            int duEst = Integer.parseInt(duracionEst);

            Actividad act = new Actividad(0,
                    nombre,
                    ejecucion.toString(),
                    intervalo,
                    horaInicio,
                    numveces,
                    null,
                    null,
                    null,
                    null,
                    duEst,
                    new Servidor(codServ),
                    new Categoria(codCat),
                    new Empresa(codEmp));

            if (fecha.length() != 0) {
                act.setFechaEspecifica(fecha);
            }
            if (descripcion.length() != 0) {
                act.setDescripcion(descripcion);
            }
            if (URLManual.length() != 0) {
                act.setURLManual(URLManual);
            }
            if (URLVideo.length() != 0) {
                act.setURLVideo(URLVideo);
            }

            if (met.equals("registro")) {

                if (this.dao_acti.Crear(act)) {
                    todo.add("OK Registro Exitoso");
                } else {
                    todo.add("Error No se pudo Registrar en DAO");
                    System.out.println("ERROR EN EL DAO");
                }
            } else {

                act.setCodigo(cod);
                if (this.dao_acti.Actualizar(act)) {
                    todo.add("OK Actualización Completa");
                } else {
                    todo.add("Error Key Invalida");
                    System.out.println("ERROR Key invalida");
                }

            }
        } else {
            todo.add("Error Campos vacios nombre, duracionEst.length(), Ejecucion, Empresa, Servidor, Categoria, Intervalo de tiempo, Hora inicio");
            System.out.println(nombre + " " + duracionEst + " " + cont + " " + empresa + "" + servidor + " " + categoria + " " + intervalotiempo + " " + horaInicio);

        }

    }

    private List<Object> obtenertodo() throws SQLException {
        List<Object> todo = new ArrayList<Object>();
        List<Empresa> emp = new ArrayList<Empresa>();
        List<Categoria> cat = new ArrayList<Categoria>();
        List<Servidor> servidores = new ArrayList<Servidor>();
        List<Actividad> act = new ArrayList<Actividad>();

        servidores = dao_serv.Obtener();
        emp = dao_emp.Obtener();
        cat = dao_cat.Obtener();
        act = dao_acti.Obtener();

        todo.add(emp);
        todo.add(cat);
        todo.add(servidores);
        todo.add(act);
        return todo;

    }

}
