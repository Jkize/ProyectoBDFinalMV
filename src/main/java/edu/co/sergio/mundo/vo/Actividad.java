package edu.co.sergio.mundo.vo;

import java.io.Serializable;

/**
 *
 * @author Jhoan Saavedra
 */
public class Actividad implements Serializable{

    private int codigo;
    private String nombre;
    private String ejecucion;
    private int intervaloTiempo;
    private String horaInicio;
    private int nroVecesDia;
    private String fechaEspecifica;
    private String descripcion;
    private String URLManual;
    private String URLVideo;
    private int duracionEst;
    private Servidor servidor;
    private Categoria categoria; 
    private Empresa empresa;

    public Actividad(int codigo) {
        this.codigo = codigo;
    }
        public Actividad() {
    }

    public Actividad(int codigo, String nombre, String ejecucion, int intervaloTiempo, String horaInicio, int nroVecesDia, String fechaEspecifica, String descripcion, String URLManual, String URLVideo, int duracionEst, Servidor servidor, Categoria categoria, Empresa empresa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ejecucion = ejecucion;
        this.intervaloTiempo = intervaloTiempo;
        this.horaInicio = horaInicio;
        this.nroVecesDia = nroVecesDia;
        this.fechaEspecifica = fechaEspecifica;
        this.descripcion = descripcion;
        this.URLManual = URLManual;
        this.URLVideo = URLVideo;
        this.duracionEst = duracionEst;
        this.servidor = servidor;
        this.categoria = categoria;
        this.empresa = empresa;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        this.ejecucion = ejecucion;
    }

    public int getIntervaloTiempo() {
        return intervaloTiempo;
    }

    public void setIntervaloTiempo(int intervaloTiempo) {
        this.intervaloTiempo = intervaloTiempo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getNroVecesDia() {
        return nroVecesDia;
    }

    public void setNroVecesDia(int nroVecesDia) {
        this.nroVecesDia = nroVecesDia;
    }

    public String getFechaEspecifica() {
        return fechaEspecifica;
    }

    public void setFechaEspecifica(String fechaEspecifica) {
        this.fechaEspecifica = fechaEspecifica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getURLManual() {
        return URLManual;
    }

    public void setURLManual(String URLManual) {
        this.URLManual = URLManual;
    }

    public String getURLVideo() {
        return URLVideo;
    }

    public void setURLVideo(String URLVideo) {
        this.URLVideo = URLVideo;
    }

    public int getDuracionEst() {
        return duracionEst;
    }

    public void setDuracionEst(int duracionEst) {
        this.duracionEst = duracionEst;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    

}
