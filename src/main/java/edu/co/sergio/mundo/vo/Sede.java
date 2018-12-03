package edu.co.sergio.mundo.vo;

import java.io.Serializable;

/**
 *
 * @author Jhoan Saavedra
 */

public class Sede implements Serializable{

    private String codigo;

    public Sede(String codigo) {
        this.codigo = codigo;
    }

    public Sede() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
