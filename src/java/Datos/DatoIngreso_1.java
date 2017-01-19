package Datos;

import Modelo.Ingreso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatoIngreso_1 extends Conexion {
    
    public void registrar(Ingreso per) throws Exception{
        
        try {
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO ingreso (ingreso_fecha, ingreso_dependencia, ingreso_operador, ingreso_dispositivo, ingreso_equipo, "
                            + "ingreso_placa, ingreso_fechaIngreso, ingreso_peaje, ingreso_sentido, ingreso_monto) "
                            + "values (?,?,?,?,?,?,?,?,?,?)");
            st.setDate(1, (java.sql.Date) per.getIngreso_fecha());
            st.setString(2, per.getIngreso_dependencia());
            st.setString(3, per.getIngreso_operador());
            st.setString(4, per.getIngreso_dispositivo());
            st.setString(5, per.getIngreso_equipo());
            st.setString(6, per.getIngreso_placa());
            st.setDate(7, (java.sql.Date) per.getIngreso_fechaIngreso());
            st.setString(8, per.getIngreso_peaje());
            st.setString(9, per.getIngreso_sentido());
            st.setInt(10, per.getIngreso_monto());
            st.executeUpdate();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {
            this.getCn().rollback();
            throw e;
        } finally {
            this.cerrar();
        }
    }
//    
//    public List<Ingreso> listar() throws Exception{
//        
//        List<Ingreso> lista;
//        ResultSet rs;
//        
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM ingreso");
//            rs = st.executeQuery();
//            lista = new ArrayList();
//            
//            while (rs.next()) {                
//                Ingreso per = new Ingreso();
//                per.setIngreso_id(rs.getInt("ingreso_id"));
//                per.setIngreso_fecha(rs.getDate("ingreso_fecha"));
//                per.setIngreso_dependencia(rs.getString("ingreso_dependencia"));
//                per.setIngreso_operador(rs.getString("ingreso_operador"));
//                per.setIngreso_dispositivo(rs.getString("ingreso_dispositivo"));
//                per.setIngreso_equipo(rs.getString("ingreso_equipo"));
//                per.setIngreso_placa(rs.getString("ingreso_placa"));
//                per.setIngreso_fechaIngreso(rs.getDate("ingreso_fechaIngreso"));
//                per.setIngreso_peaje(rs.getString("ingreso_peaje"));
//                per.setIngreso_sentido(rs.getString("ingreso_sentido"));
//                per.setIngreso_monto(rs.getInt("ingreso_monto"));
//                
//                lista.add(per);
//            }
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }
//    
//    public Ingreso leerID(Ingreso per) throws Exception{
//        
//        Ingreso pers = null;
//        ResultSet rs;
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM ingreso WHERE ingreso_id = ?");
//            st.setInt(1, per.getIngreso_id());
//            rs = st.executeQuery();
//            
//            while (rs.next()) {
//                pers = new Ingreso();
//                pers.setIngreso_id(rs.getInt("ingreso_id"));
//                pers.setIngreso_fecha(rs.getDate("ingreso_fecha"));
//                pers.setIngreso_dependencia(rs.getString("ingreso_dependencia"));
//                pers.setIngreso_operador(rs.getString("ingreso_operador"));
//                pers.setIngreso_dispositivo(rs.getString("ingreso_dispositivo"));
//                pers.setIngreso_equipo(rs.getString("ingreso_equipo"));
//                pers.setIngreso_placa(rs.getString("ingreso_placa"));
//                pers.setIngreso_fechaIngreso(rs.getDate("ingreso_fechaIngreso"));
//                pers.setIngreso_peaje(rs.getString("ingreso_peaje"));
//                pers.setIngreso_sentido(rs.getString("ingreso_sentido"));
//                pers.setIngreso_monto(rs.getInt("ingreso_monto"));
//            }
//            
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        
//        return pers;
//    }
//    
//    public void modificar(Ingreso per) throws Exception{
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("UPDATE ingreso SET ingreso_fecha = ?, ingreso_dependencia = ?, ingreso_operador = ?, ingreso_dispositivo = ?, ingreso_equipo = ?, "
//                            + "ingreso_placa = ?, ingreso_fechaIngreso = ?, ingreso_peaje = ?, ingreso_sentido = ?, ingreso_monto = ? WHERE ingreso_id = ?");
//            st.setDate(1, (java.sql.Date) per.getIngreso_fecha());
//            st.setString(2, per.getIngreso_dependencia());
//            st.setString(3, per.getIngreso_operador());
//            st.setString(4, per.getIngreso_dispositivo());
//            st.setString(5, per.getIngreso_equipo());
//            st.setString(6, per.getIngreso_placa());
//            st.setDate(7, (java.sql.Date) per.getIngreso_fechaIngreso());
//            st.setString(8, per.getIngreso_peaje());
//            st.setString(9, per.getIngreso_sentido());
//            st.setInt(10, per.getIngreso_monto());
//            st.setInt(11, per.getIngreso_id());
//            st.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//    }
//    
//    public void eliminarID(Ingreso per) throws Exception{
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM ingreso WHERE ingreso_id = ?");
//            st.setInt(1, per.getIngreso_id());
//            st.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//    }
    
}
