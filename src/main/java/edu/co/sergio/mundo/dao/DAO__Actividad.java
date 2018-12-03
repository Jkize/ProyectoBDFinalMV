package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Actividad;
import edu.co.sergio.mundo.vo.Servidor;
import edu.co.sergio.mundo.vo.Categoria;
import edu.co.sergio.mundo.vo.Empresa;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author @since
 *
 */
public class DAO__Actividad implements DAO<Actividad> {

    private final Connection conexion;

    public DAO__Actividad() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
    }

    @Override
    public List<Actividad> Obtener() throws SQLException {
        List<Actividad> actividades = new ArrayList<Actividad>();
        String query = "SELECT * FROM Actividad ORDER BY codigo DESC";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fechaesp = ((rs.getDate("fechaesp") == null) ? "Null" : df.format(rs.getDate("fechaesp")));
                String descripcion = ((rs.getString("descripcion") == null) ? "Null" : rs.getString("descripcion"));
                String URLManual = ((rs.getString("URLManual") == null) ? "Null" : rs.getString("URLManual"));
                String URLVideo = ((rs.getString("URLVideo") == null) ? "Null" : rs.getString("URLVideo"));

                Actividad acti = new Actividad(rs.getInt("codigo"),
                        rs.getString("nombre"), rs.getString("ejecucion"),
                        rs.getInt("intervalotiempo"), rs.getTime("horainicio").toString(), rs.getInt("nroveces"), fechaesp,
                        descripcion, URLManual, URLVideo,
                        rs.getInt("duracionest"), new Servidor(rs.getInt("servidor1")), new Categoria(rs.getInt("categoria1")), new Empresa(rs.getInt("empresa1")));

                PreparedStatement Smt = conexion.prepareStatement("select * from Servidor where codigo=?");
                Smt.setLong(1, acti.getServidor().getCodigo());
                ResultSet rs2 = Smt.executeQuery();
                if (rs2.next()) {
                    acti.getServidor().setNombre(rs2.getString("nombre"));
                }
                Smt = conexion.prepareStatement("select * from Categoria where codigo=?");
                Smt.setLong(1, acti.getCategoria().getCodigo());
                rs2 = Smt.executeQuery();
                if (rs2.next()) {
                    acti.getCategoria().setNombre(rs2.getString("nombre"));
                }

                Smt = conexion.prepareStatement("select * from Empresa where codigo=?");
                Smt.setLong(1, acti.getEmpresa().getCodigo());
                rs2 = Smt.executeQuery();
                if (rs2.next()) {
                    acti.getEmpresa().setNombre(rs2.getString("nombre"));
                }
                actividades.add(acti);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return actividades;

    }

    @Override
    public boolean Crear(Actividad t) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");

        boolean Resultado = false;
        String query = "INSERT INTO Actividad(Nombre,Ejecucion,IntervaloTiempo,HoraInicio,NroVeces,FechaEsp,Descripcion,URLManual,URLVideo,DuracionEst,Servidor1,Categoria1,Empresa1) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement Smt = null;
        try {
            Smt = conexion.prepareStatement(query);

            java.sql.Time time = new java.sql.Time(sdf.parse(t.getHoraInicio()).getTime());
            Smt.setString(1, t.getNombre());
            Smt.setString(2, t.getEjecucion());
            Smt.setInt(3, t.getIntervaloTiempo());
            Smt.setTime(4, time);
            Smt.setInt(5, t.getNroVecesDia());

            if (t.getFechaEspecifica() == null) {
                Smt.setDate(6, null);
            } else {
                java.sql.Date fechaSQL = new java.sql.Date(sdfdate.parse(t.getFechaEspecifica()).getTime());
                Smt.setDate(6, fechaSQL);

            }
            Smt.setString(7, t.getDescripcion());
            Smt.setString(8, t.getURLManual());
            Smt.setString(9, t.getURLVideo());
            Smt.setInt(10, t.getDuracionEst());
            Smt.setInt(11, t.getServidor().getCodigo());
            Smt.setInt(12, t.getCategoria().getCodigo());
            Smt.setInt(13, t.getEmpresa().getCodigo());

            if (Smt.executeUpdate() > 0) {
                Resultado = true;
            }

            Smt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(DAO__Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Resultado;

    }

    public boolean Crear2(Actividad t, String queryFinal) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");

        boolean Resultado = false;
        String query = queryFinal + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement Smt = null;
        try {
            Smt = conexion.prepareStatement(query);

            java.sql.Time time = new java.sql.Time(sdf.parse(t.getHoraInicio()).getTime());
            Smt.setString(1, t.getNombre());
            Smt.setString(2, t.getEjecucion());
            Smt.setInt(3, t.getIntervaloTiempo());
            Smt.setTime(4, time);
            Smt.setInt(5, t.getNroVecesDia());
            
            if (t.getFechaEspecifica() == null) {
                Smt.setDate(6, null);
            } else {
                java.sql.Date fechaSQL = new java.sql.Date(sdfdate.parse(t.getFechaEspecifica()).getTime());
                Smt.setDate(6, fechaSQL);

            }
            
            Smt.setString(7, t.getURLManual());
            Smt.setString(8, t.getURLVideo());
            Smt.setInt(9, t.getServidor().getCodigo());
            Smt.setInt(10, t.getCategoria().getCodigo());
            Smt.setInt(11, t.getDuracionEst());
            Smt.setString(12, t.getDescripcion());
            Smt.setInt(13, t.getEmpresa().getCodigo());

            if (Smt.executeUpdate() > 0) {
                Resultado = true;
            }

            Smt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(DAO__Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Resultado;

    }
    
    @Override
    public boolean Actualizar(Actividad t) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");

        boolean Resultado = false;
        String query = "UPDATE Actividad set Nombre=?,Ejecucion=?,IntervaloTiempo=?,HoraInicio=?,NroVeces=?,FechaEsp=?,Descripcion=?,URLManual=?,URLVideo=?,DuracionEst=?,Servidor1=?,Categoria1=?,Empresa1=? WHERE codigo=?;";
        PreparedStatement Smt = null;
        try {
            Smt = conexion.prepareStatement(query);

            java.sql.Time time = new java.sql.Time(sdf.parse(t.getHoraInicio()).getTime());
            Smt.setString(1, t.getNombre());
            Smt.setString(2, t.getEjecucion());
            Smt.setInt(3, t.getIntervaloTiempo());
            Smt.setTime(4, time);
            Smt.setInt(5, t.getNroVecesDia());

            if (t.getFechaEspecifica() == null) {
                Smt.setDate(6, null);
            } else {
                java.sql.Date fechaSQL = new java.sql.Date(sdfdate.parse(t.getFechaEspecifica()).getTime());
                Smt.setDate(6, fechaSQL);

            }
            Smt.setString(7, t.getDescripcion());
            Smt.setString(8, t.getURLManual());
            Smt.setString(9, t.getURLVideo());
            Smt.setInt(10, t.getDuracionEst());
            Smt.setInt(11, t.getServidor().getCodigo());
            Smt.setInt(12, t.getCategoria().getCodigo());
            Smt.setInt(13, t.getEmpresa().getCodigo());

            Smt.setInt(14, t.getCodigo());
            
            if (Smt.executeUpdate() > 0) {
                Resultado = true;
            }

            Smt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(DAO__Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Resultado;

    }

    @Override
    public boolean Eliminar(Actividad t) throws SQLException {
  boolean result = false; 
        String query = "delete from Actividad where codigo = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt(1, t.getCodigo()); 
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }
            preparedStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public Actividad buscar(int codigo) {
        Actividad acti = null;
        String query = "SELECT * FROM Actividad WHERE codigo=" + codigo;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fechaesp = ((rs.getDate("fechaesp") == null) ? "" : df.format(rs.getDate("fechaesp")));
                String descripcion = ((rs.getString("descripcion") == null) ? "" : rs.getString("descripcion"));
                String URLManual = ((rs.getString("URLManual") == null) ? "" : rs.getString("URLManual"));
                String URLVideo = ((rs.getString("URLVideo") == null) ? "" : rs.getString("URLVideo"));
                acti = new Actividad(rs.getInt("codigo"),
                        rs.getString("nombre"), rs.getString("ejecucion"),
                        rs.getInt("intervalotiempo"), rs.getTime("horainicio").toString(), rs.getInt("nroveces"), fechaesp,
                        descripcion, URLManual, URLVideo,
                        rs.getInt("duracionest"), new Servidor(rs.getInt("servidor1")), new Categoria(rs.getInt("categoria1")), new Empresa(rs.getInt("empresa1")));

                PreparedStatement Smt = conexion.prepareStatement("select * from Servidor where codigo=?");
                Smt.setLong(1, acti.getServidor().getCodigo());
                ResultSet rs2 = Smt.executeQuery();
                if (rs2.next()) {
                    acti.getServidor().setNombre(rs2.getString("nombre"));
                }
                Smt = conexion.prepareStatement("select * from Categoria where codigo=?");
                Smt.setLong(1, acti.getCategoria().getCodigo());
                rs2 = Smt.executeQuery();
                if (rs2.next()) {
                    acti.getCategoria().setNombre(rs2.getString("nombre"));
                }

                Smt = conexion.prepareStatement("select * from Empresa where codigo=?");
                Smt.setLong(1, acti.getEmpresa().getCodigo());
                rs2 = Smt.executeQuery();
                if (rs2.next()) {
                    acti.getEmpresa().setNombre(rs2.getString("nombre"));
                }

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }
        return acti;
    }

    

}
