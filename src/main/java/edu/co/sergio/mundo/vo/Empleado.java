package edu.co.sergio.mundo.vo;

import java.io.Serializable;

/**
 *
 * @author Jhoan Saavedra
 */

public class Empleado implements Serializable{

    private String correo;
    private String nombre;
    private String contrasena;
    private String cargo;
    private Sede sede;
    private String turno;

    public Empleado() {
    }

    public Empleado(String correo, String nombre, String contrasena, String cargo, Sede sede) {
        this.correo = correo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cargo = cargo;
        this.sede = sede;
    }

    public Empleado(String correo, String nombre, String contrasena, String cargo) {
        this.correo = correo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cargo = cargo;
    }

    public Empleado(String correo,String nombre, String  turno) {
      this.correo = correo;
        this.nombre = nombre;
      this.turno= turno;
    }

    public Empleado(String Correo) {
    this.correo = Correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    

}
