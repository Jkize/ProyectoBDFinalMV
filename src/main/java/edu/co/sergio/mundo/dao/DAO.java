package edu.co.sergio.mundo.dao;

import java.sql.SQLException;
import java.util.List;


/**
 * 
 * @author 
 * @since 
 * 
 */

public interface DAO<T> {

    List<T> Obtener() throws SQLException;
    boolean Crear(T t) throws SQLException;
    boolean Actualizar(T t) throws SQLException;
    boolean Eliminar(T t) throws SQLException;

}
