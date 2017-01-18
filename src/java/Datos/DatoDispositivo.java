package Datos;

import Modelo.Dispositivo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatoDispositivo extends Conexion {

    public void registrar(Dispositivo per) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO dispositivo (dispositivo_reserva, dispositivo_registroContable, "
                    + ", dispositivo_tarjeta, dispositivo_periodoCobro, dispositivo_factura, dispositivo_montoFacturas"
                    + "values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, per.getDispositivo_reserva());
            st.setString(2, per.getDispositivo_registroContable());
            st.setString(3, per.getDispositivo_programaBCR());
            st.setString(4, per.getDispositivo_tarjeta());
            st.setString(5, per.getDispositivo_periodoCobro());
            st.setString(6, per.getDispositivo_factura());
            st.setDouble(7, per.getDispositivo_montoFacturas());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public List<Dispositivo> listar() throws Exception {

        List<Dispositivo> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM dispositivo");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {

                Dispositivo per = new Dispositivo();
                per.setDispositivo_id(rs.getInt("dispositivo_id"));
                per.setDispositivo_reserva(rs.getString("dispositivo_reserva"));
                per.setDispositivo_registroContable(rs.getString("dispositivo_registroContable"));
                per.setDispositivo_programaBCR(rs.getString("dispositivo_programaBCR"));
                per.setDispositivo_tarjeta(rs.getString("dispositivo_tarjeta"));
                per.setDispositivo_periodoCobro(rs.getString("dispositivo_periodoCobro"));
                per.setDispositivo_factura(rs.getString("dispositivo_factura"));
                per.setDispositivo_montoFacturas(rs.getDouble("dispositivo_montoFacturas"));
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public Dispositivo leerID(Dispositivo per) throws Exception {

        Dispositivo pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM dispositivo WHERE dispositivo_id = ?");
            st.setInt(1, per.getDispositivo_id());
            rs = st.executeQuery();

            while (rs.next()) {
                pers = new Dispositivo();
                pers.setDispositivo_id(rs.getInt("dispositivo_id"));
                pers.setDispositivo_reserva(rs.getString("dispositivo_reserva"));
                pers.setDispositivo_registroContable(rs.getString("dispositivo_registroContable"));
                pers.setDispositivo_programaBCR(rs.getString("dispositivo_programaBCR"));
                pers.setDispositivo_tarjeta(rs.getString("dispositivo_tarjeta"));
                pers.setDispositivo_periodoCobro(rs.getString("dispositivo_periodoCobro"));
                pers.setDispositivo_factura(rs.getString("dispositivo_factura"));
                pers.setDispositivo_montoFacturas(rs.getDouble("dispositivo_montoFacturas"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

        return pers;
    }

    public void modificar(Dispositivo per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE dispositivo SET dispositivo_reserva = ?, dispositivo_registroContable = ?, "
                    + "dispositivo_programaBCR = ?, dispositivo_tarjeta = ?, dispositivo_periodoCobro = ?, dispositivo_factura = ?, dispositivo_montoFacturas = ? WHERE dispositivo_id = ?");
            st.setString(1, per.getDispositivo_reserva());
            st.setString(2, per.getDispositivo_registroContable());
            st.setString(3, per.getDispositivo_programaBCR());
            st.setString(4, per.getDispositivo_tarjeta());
            st.setString(5, per.getDispositivo_periodoCobro());
            st.setString(6, per.getDispositivo_factura());
            st.setDouble(7, per.getDispositivo_montoFacturas());
            st.setInt(8, per.getDispositivo_id());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public void eliminarID(Dispositivo per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM dispositivo WHERE dispositivo_id = ?");
            st.setInt(1, per.getDispositivo_id());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
