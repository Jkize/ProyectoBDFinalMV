package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Actividad;
import edu.co.sergio.mundo.vo.Empleado;
import edu.co.sergio.mundo.vo.Seguimiento;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @since
 *
 */
public class DAO__Seguimiento implements DAO<Seguimiento> {

    private final Connection conexion;

    public DAO__Seguimiento() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        conexion = Conexion.getConnection();
    }

    @Override
    public List<Seguimiento> Obtener() throws SQLException {

        List<Seguimiento> segui = null;
        String query = "SELECT * FROM Seguimiento";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            int codigo = 0;
            int codigoActividad=0;
            String Estado = null, HoraInicio = null, HoraFin = null, Observaciones = null, Correo = null;
            
            while (rs.next()) {
                if (segui == null) {
                    segui = new ArrayList<Seguimiento>();
                }

                Seguimiento registro = new Seguimiento();
                
                codigo = rs.getInt("codigo");
                registro.setCodigo(codigo);
                
                Estado = rs.getString("Estado");
                registro.setEstado(Estado);
                
                HoraInicio = rs.getString("HoraInicio");
                registro.setHoraInicio(HoraInicio);
                
                HoraFin = rs.getString("HoraFin");
                registro.setHoraFin(HoraFin);
                
                Observaciones = rs.getString("Observaciones");
                registro.setObservaciones(Observaciones);
                
                codigoActividad = rs.getInt("Actividad1");
                registro.setActividad(new Actividad(codigoActividad));
                
                Correo = rs.getString("Empleado1");
                registro.setEmpleado(new Empleado(Correo));
                
                segui.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return segui;

    }

    @Override
    public boolean Crear(Seguimiento t) throws SQLException {

        boolean result = false;

        String query = " insert into Seguimiento" + " values (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);

            preparedStmt.setString(1, t.getEstado());
            preparedStmt.setString(2, t.getHoraInicio());
            preparedStmt.setString(3, t.getHoraFin());
            preparedStmt.setString(4, t.getObservaciones());
            preparedStmt.setLong(5, t.getActividad().getCodigo());
            preparedStmt.setString(6, t.getEmpleado().getCorreo());
            result = preparedStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean Actualizar(Seguimiento t) throws SQLException {

        boolean result = false;

        String query = "update Seguimiento set Estado = ?, HoraInicio = ?, HoraFin = ?, Observaciones = ? where Codigo = ? AND Actividad1 = ? AND Empleado1 = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);

            preparedStmt.setString(1, t.getEstado());
            preparedStmt.setString(2, t.getHoraInicio());
            preparedStmt.setString(3, t.getHoraFin());
            preparedStmt.setString(4, t.getObservaciones());
            preparedStmt.setInt(5, t.getCodigo());
            preparedStmt.setLong(6, t.getActividad().getCodigo());
            preparedStmt.setString(7, t.getEmpleado().getCorreo());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean Eliminar(Seguimiento t) throws SQLException {

        boolean result = false;

        String query = "delete from Seguimiento where codigo = ?";

        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt(1, t.getCodigo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    
    /**
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        DAO__Seguimiento a = new DAO__Seguimiento();
      
        
    }**/
    
    
}
