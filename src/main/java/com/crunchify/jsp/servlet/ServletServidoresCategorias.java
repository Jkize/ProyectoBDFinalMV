/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.vo.Categoria;
import edu.co.sergio.mundo.dao.DAO__Categoria;
import edu.co.sergio.mundo.dao.DAO__Servidor;
import edu.co.sergio.mundo.vo.Servidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
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
public class ServletServidoresCategorias extends HttpServlet {

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
        RequestDispatcher rq = request.getRequestDispatcher("ServidoresCategorias.jsp");
        try {
            DAO__Servidor daoSer = new DAO__Servidor();
            DAO__Categoria daoCat = new DAO__Categoria();
            List<Servidor> servidores = daoSer.Obtener();

            JSONObject ob = new JSONObject();
            JSONArray matrix = new JSONArray();
            for (Servidor servidor : servidores) {
                JSONArray fila = new JSONArray();
                fila.put(servidor.getCodigo());
                fila.put(servidor.getNombre());
                matrix.put(fila);
            }
            ob.put("servidores", matrix);

            List<Categoria> categorias = daoCat.Obtener();
            matrix = new JSONArray();
            for (Categoria categoria : categorias) {
                JSONArray fila = new JSONArray();
                fila.put(categoria.getCodigo());
                fila.put(categoria.getNombre());
                matrix.put(fila);
            }
            ob.put("categorias", matrix);

            request.setAttribute("todo", (String) ob.toString());
            rq.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
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

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String BregistrarC = request.getParameter("registrarC");
        String BregistrarS = request.getParameter("registrarS");

        String BbuscarC = request.getParameter("buscarC");
        String BbuscarS = request.getParameter("buscarS");

        String BactualizarC = request.getParameter("actualizarC");
        String BactualizarS = request.getParameter("actualizarS");

        String BeliminarC = request.getParameter("eliminarC");
        String BeliminarS = request.getParameter("eliminarS");

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");

        JSONObject ob = new JSONObject();

        if (BregistrarS != null) {

            try {
                DAO__Servidor daoSer = new DAO__Servidor();

                if (daoSer.Crear(new Servidor(0, nombre))) {
                    ob = obtenerServidores();
                    ob.put("succes", "Registro Correcto");
                    out.println(ob);
                } else {
                    out.println("{\"error\":\"No se pudo Registrar\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (BregistrarC != null) {
            try {
                DAO__Categoria daoCat = new DAO__Categoria();

                if (daoCat.Crear(new Categoria(0, nombre))) {
                    ob = obtenerCategorias();
                    ob.put("succes", "Registro Correcto");

                    out.println(ob);
                } else {
                    out.println("{\"error\":\"No se pudo Registrar\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BbuscarC != null) {
            try {
                DAO__Categoria daoCat = new DAO__Categoria();
                Categoria cat = daoCat.Buscar(Integer.parseInt(codigo));
                if (cat != null) {
                    ob.put("succes", "Busqueda Correcta");
                    ob.put("codigo", cat.getCodigo());
                    ob.put("nombre", cat.getNombre());
                    out.println(ob);
                } else {
                    out.println("{\"error\":\"Codigo incorrecto\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                out.println("{\"error\":\"El codigo debe ser un número\"}");
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BbuscarS != null) {
            try {
                DAO__Servidor daoServ = new DAO__Servidor();
                Servidor serv = daoServ.Buscar(Integer.parseInt(codigo));
                if (serv != null) {
                    ob.put("succes", "Busqueda Correcta");
                    ob.put("codigo", serv.getCodigo());
                    ob.put("nombre", serv.getNombre());
                    out.println(ob);
                } else {
                    out.println("{\"error\":\"Codigo incorrecto\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                out.println("{\"error\":\"El codigo debe ser un número\"}");
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BactualizarS != null) {

            try {
                DAO__Servidor daoServ = new DAO__Servidor();
                Servidor serv = new Servidor(Integer.parseInt(codigo), nombre);

                if (daoServ.Actualizar(serv)) {
                      ob = obtenerServidores();
                    ob.put("succes", "Actualización Correcta");                  
                    out.println(ob);
                } else {
                    out.println("{\"error\":\"Codigo incorrecto\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                out.println("{\"error\":\"El codigo debe ser un número\"}");
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BactualizarC != null) {

            try {
                DAO__Categoria daoCat = new DAO__Categoria();
                Categoria cat = new Categoria(Integer.parseInt(codigo), nombre);

                if (daoCat.Actualizar(cat)) {
                    ob = obtenerCategorias();
                    ob.put("succes", "Actualización Correcta");
                     
                    out.println(ob);
                } else {
                    out.println("{\"error\":\"Codigo incorrecto\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                out.println("{\"error\":\"El codigo debe ser un número\"}");
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BeliminarC != null) {
            try {
                DAO__Categoria daoCat = new DAO__Categoria();

                if (daoCat.Eliminar(new Categoria(Integer.parseInt(codigo)))) {
                    ob = obtenerCategorias();
                    ob.put("succes", "Eliminacion Correcta");
                    out.println(ob);
                } else {
                    out.println("{\"error\":\"Codigo incorrecto\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                out.println("{\"error\":\"El codigo debe ser un número\"}");
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BeliminarS != null) {
            try {
                DAO__Servidor daServ = new DAO__Servidor();

                if (daServ.Eliminar(new Servidor(Integer.parseInt(codigo)))) {
                    ob = obtenerServidores();
                    ob.put("succes", "Eliminacion Correcta");

                    out.println(ob);
                } else {
                    out.println("{\"error\":\"Codigo incorrecto\"}");
                }

            } catch (SQLException ex) {
                out.println("{\"error\":\"Error SQL\"}");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                out.println("{\"error\":\"El codigo debe ser un número\"}");
            } catch (URISyntaxException ex) {
                Logger.getLogger(ServletServidoresCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public JSONObject obtenerServidores() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, JSONException, URISyntaxException {
        DAO__Servidor daoSer = new DAO__Servidor();
        List<Servidor> servidores = daoSer.Obtener();
        JSONObject ob = new JSONObject();
        JSONArray matrix = new JSONArray();
        for (Servidor servidor : servidores) {
            JSONArray fila = new JSONArray();
            fila.put(servidor.getCodigo());
            fila.put(servidor.getNombre());
            matrix.put(fila);
        }
        ob.put("servidores", matrix);
        return ob;
    }

    public JSONObject obtenerCategorias() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, JSONException, URISyntaxException {
        DAO__Categoria daoCat = new DAO__Categoria();

        JSONObject ob = new JSONObject();
        List<Categoria> categorias = daoCat.Obtener();
        JSONArray matrix = new JSONArray();
        for (Categoria categoria : categorias) {
            JSONArray fila = new JSONArray();
            fila.put(categoria.getCodigo());
            fila.put(categoria.getNombre());
            matrix.put(fila);
        }
        ob.put("categorias", matrix);
        return ob;
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
