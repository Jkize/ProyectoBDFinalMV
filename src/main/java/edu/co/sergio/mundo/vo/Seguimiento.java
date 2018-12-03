package edu.co.sergio.mundo.vo;

import java.io.Serializable;

/**
 * SEGUIIENTO V.2
 * 
 * @author Sebastian
 * @since 13-10-18
 */

public class Seguimiento implements Serializable{

    private int codigo;
    private String Estado;
    private String HoraInicio;
    private String HoraFin;
    private String Observaciones; 
    private Actividad actividad;
    private Empleado empleado;

    public Seguimiento(int codigo, String Estado, String HoraInicio, String HoraFin, String Observaciones, Actividad actividad, Empleado empleado) {
        this.codigo = codigo;
        this.Estado = Estado;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.Observaciones = Observaciones;
        this.actividad = actividad;
        this.empleado = empleado;
    }

    public Seguimiento(){
    }
    
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

   
   
}
