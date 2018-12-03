package edu.co.sergio.mundo.vo;

import java.io.Serializable;

/**
 *
 * @author Jhoan Saavedra
 */

public class Servidor implements Serializable{

    private Integer codigo;
    private String nombre; 
    
    public Servidor(Integer codigo) {
        this.codigo = codigo;
    }
    
    
    
    public Servidor() {
    }

    
    public Servidor(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
       
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 

}
