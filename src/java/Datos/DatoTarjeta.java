package Datos;

import Modelo.Tarjeta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatoTarjeta extends Conexion {

    public void registrar(Tarjeta per) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO tarjeta (tarjeta_id, tarjeta_dependencia, tarjeta_ejecutor, tarjeta_programa, tarjeta_encargadoTarjeta, tarjeta_subprograma,\n"
                    + "tarjeta_areaActividad, tarjeta_cedula, tarjeta_correoElectronico, tarjeta_numeroOficina, tarjeta_domicilioEncargadoTarjeta,\n"
                    + "tarjeta_fecha, tarjeta_codigoBCR, tarjeta_operador, tarjeta_cedulaOperador, tarjeta_numeroEquipo, tarjeta_numeroPlaca)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setDate(1, (java.sql.Date) per.getTarjeta_fecha());
            st.setInt(2, per.getTarjeta_id());
            st.setString(3, per.getTarjeta_dependencia());
            st.setString(4, per.getTarjeta_ejecutor());
            st.setString(5, per.getTarjeta_programa());
            st.setString(6, per.getTarjeta_encargadoTarjeta());
            st.setString(7, per.getTarjeta_subprograma());
            st.setString(8, per.getTarjeta_areaActividad());
            st.setString(9, per.getTarjeta_cedula());
            st.setString(10, per.getTarjeta_correoElectronico());
            st.setString(11, per.getTarjeta_numeroOficina());
            st.setString(12, per.getTarjeta_domicilioEncargadoTarjeta());
            st.setString(13, per.getTarjeta_codigoBCR());
            st.setString(14, per.getTarjeta_operador());
            st.setString(15, per.getTarjeta_cedulaOperador());
            st.setString(16, per.getTarjeta_numeroEquipo());
            st.setString(17, per.getTarjeta_numeroPlaca());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public List<Tarjeta> listar() throws Exception {

        List<Tarjeta> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM tarjeta");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {

                Tarjeta per = new Tarjeta();
                per.setTarjeta_id(rs.getInt("tarjeta_id"));
                per.setTarjeta_fecha(rs.getDate("tarjeta_fecha"));
                per.setTarjeta_dependencia(rs.getString("tarjeta_dependencia"));
                per.setTarjeta_ejecutor(rs.getString("tarjeta_ejecutor"));
                per.setTarjeta_programa(rs.getString("tarjeta_programa"));
                per.setTarjeta_encargadoTarjeta(rs.getString("tarjeta_encargadoTarjeta"));
                per.setTarjeta_subprograma(rs.getString("tarjeta_subprograma"));
                per.setTarjeta_areaActividad(rs.getString("tarjeta_areaActividad"));
                per.setTarjeta_cedula(rs.getString("tarjeta_cedula"));
                per.setTarjeta_correoElectronico(rs.getString("tarjeta_correoElectronico"));
                per.setTarjeta_numeroOficina(rs.getString("tarjeta_numeroOficina"));
                per.setTarjeta_domicilioEncargadoTarjeta(rs.getString("tarjeta_domicilioEncargadoTarjeta"));
                per.setTarjeta_codigoBCR(rs.getString("tarjeta_codigoBCR"));
                per.setTarjeta_operador(rs.getString("tarjeta_operador"));
                per.setTarjeta_cedulaOperador(rs.getString("tarjeta_cedulaOperador"));
                per.setTarjeta_numeroEquipo(rs.getString("tarjeta_numeroEquipo"));
                per.setTarjeta_numeroPlaca(rs.getString("tarjeta_numeroPlaca"));

                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public Tarjeta leerID(Tarjeta per) throws Exception {

        Tarjeta pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM tarjeta WHERE tarjeta_id = ?");
            st.setInt(1, per.getTarjeta_id());
            rs = st.executeQuery();

            while (rs.next()) {
                pers = new Tarjeta();
                pers.setTarjeta_id(rs.getInt("tarjeta_id"));
                pers.setTarjeta_fecha(rs.getDate("tarjeta_fecha"));
                pers.setTarjeta_dependencia(rs.getString("tarjeta_dependencia"));
                pers.setTarjeta_ejecutor(rs.getString("tarjeta_ejecutor"));
                pers.setTarjeta_programa(rs.getString("tarjeta_programa"));
                pers.setTarjeta_encargadoTarjeta(rs.getString("tarjeta_encargadoTarjeta"));
                pers.setTarjeta_subprograma(rs.getString("tarjeta_subprograma"));
                pers.setTarjeta_areaActividad(rs.getString("tarjeta_areaActividad"));
                pers.setTarjeta_cedula(rs.getString("tarjeta_cedula"));
                pers.setTarjeta_correoElectronico(rs.getString("tarjeta_correoElectronico"));
                pers.setTarjeta_numeroOficina(rs.getString("tarjeta_numeroOficina"));
                pers.setTarjeta_domicilioEncargadoTarjeta(rs.getString("tarjeta_domicilioEncargadoTarjeta"));
                pers.setTarjeta_codigoBCR(rs.getString("tarjeta_codigoBCR"));
                pers.setTarjeta_operador(rs.getString("tarjeta_operador"));
                pers.setTarjeta_cedulaOperador(rs.getString("tarjeta_cedulaOperador"));
                pers.setTarjeta_numeroEquipo(rs.getString("tarjeta_numeroEquipo"));
                pers.setTarjeta_numeroPlaca(rs.getString("tarjeta_numeroPlaca"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

        return pers;
    }

    public void modificar(Tarjeta per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE tarjeta SET tarjeta_id = ?, tarjeta_dependencia = ?, tarjeta_ejecutor = ?, tarjeta_programa = ?, tarjeta_encargadoTarjeta = ?,"
                    + " tarjeta_subprograma = ?,tarjeta_areaActividad = ?, tarjeta_cedula = ?, tarjeta_correoElectronico = ?, tarjeta_numeroOficina = ?,"
                    + "tarjeta_domicilioEncargadoTarjeta = ?, tarjeta_fecha = ?, tarjeta_codigoBCR = ?, tarjeta_operador = ?, tarjeta_cedulaOperador = ?,"
                    + "tarjeta_numeroEquipo = ?, tarjeta_numeroPlaca = ? WHERE tarjeta_id = ?");
            st.setDate(1, (java.sql.Date) per.getTarjeta_fecha());
            st.setInt(2, per.getTarjeta_id());
            st.setString(3, per.getTarjeta_dependencia());
            st.setString(4, per.getTarjeta_ejecutor());
            st.setString(5, per.getTarjeta_programa());
            st.setString(6, per.getTarjeta_encargadoTarjeta());
            st.setString(7, per.getTarjeta_subprograma());
            st.setString(8, per.getTarjeta_areaActividad());
            st.setString(9, per.getTarjeta_cedula());
            st.setString(10, per.getTarjeta_correoElectronico());
            st.setString(11, per.getTarjeta_numeroOficina());
            st.setString(12, per.getTarjeta_domicilioEncargadoTarjeta());
            st.setString(13, per.getTarjeta_codigoBCR());
            st.setString(14, per.getTarjeta_operador());
            st.setString(15, per.getTarjeta_cedulaOperador());
            st.setString(16, per.getTarjeta_numeroEquipo());
            st.setString(17, per.getTarjeta_numeroPlaca());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void eliminarID(Tarjeta per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM tarjeta WHERE tarjeta_id = ?");
            st.setInt(1, per.getTarjeta_id());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
