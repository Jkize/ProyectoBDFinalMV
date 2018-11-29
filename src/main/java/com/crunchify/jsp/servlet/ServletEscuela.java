/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.DAOEscuela;
import edu.co.sergio.mundo.dao.DAOEstudiante;
import edu.co.sergio.mundo.dao.DAOPersona;
import edu.co.sergio.mundo.vo.Escuela;
import edu.co.sergio.mundo.vo.Estudiante;
import edu.co.sergio.mundo.vo.Pais;
import edu.co.sergio.mundo.vo.Persona;
import java.io.IOException;
import java.sql.Date;
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
 * @author fabian.giraldo
 */
public class ServletEscuela extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOEscuela daoEscuela = new DAOEscuela();
        List<Escuela> escuelas = daoEscuela.findAll();
        request.setAttribute("escuelas", escuelas);
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String escuela = request.getParameter("escuela");

        DAOEstudiante daoEstudiante = new DAOEstudiante();
        List<Estudiante> estudiantes = daoEstudiante.findAllByEscuela(Integer.parseInt(escuela));
        request.setAttribute("estudiantes", estudiantes);
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);

    }
}
