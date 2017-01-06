package Datos;

import Modelo.Ingreso;
import Modelo.Peaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.SelectItem;

public class DatoPago extends Conexion {
    
    public List<SelectItem> getPeajeNombre() {
        List<SelectItem> nombrePeaje = new ArrayList<SelectItem>();
        ResultSet rs;
        try {
            this.Conectar();
//        per.setFechaRegisto(this.obtenerHora());
            PreparedStatement st = this.getCn().prepareStatement("SELECT peaje_nombre FROM peaje");
            rs = st.executeQuery();
            
            while (rs.next()) {
                nombrePeaje.add(new SelectItem(rs.getString("peaje_nombre")));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return nombrePeaje;
    }
    
    public List<SelectItem> getPeajeSentido() {
        List<SelectItem> peajeSentido = new ArrayList<SelectItem>();
        Peaje peaje = new Peaje();
        ResultSet rs;
        try {
            this.Conectar();
//        per.setFechaRegisto(this.obtenerHora());
            PreparedStatement st = this.getCn().prepareStatement("SELECT peaje_sentido from peaje where peaje_id=(select items_id from items where items_name='" + peaje.getSentido() + "')");
            rs = st.executeQuery();
            
            while (rs.next()) {
                peajeSentido.add(new SelectItem(rs.getString("peaje_sentido")));
            }
            
        } catch (Exception ex) {}
        return peajeSentido;
    }
    
    public void registrar(Ingreso per) throws Exception{
        
        try {
            this.Conectar();
//        per.setFechaRegisto(this.obtenerHora());
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO ingreso (ingreso_idPersona, ingreso_idDispositivo, ingreso_idPeaje, ingreso_fecha) "
                            + "values (?,?,?,?)");
            st.setInt(1, per.getIdPersona());
            st.setInt(2, per.getIdDispositivo());
            st.setInt(3, per.getIdPeaje());
            st.setDate(4, (java.sql.Date) (Date) per.getFecha());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
//    public String obtenerHora(){
//        
//        Calendar c = GregorianCalendar.getInstance();
//        Date fecha = c.getTime();
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//        String fechaFinal = f.format(fecha);
//        
//        return fechaFinal;
//    }
    
    public List<Ingreso> listar() throws Exception{
        
        List<Ingreso> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM ingreso");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {                
                Ingreso per = new Ingreso();
                per.setIdPersona(rs.getInt("ingreso_idPersona"));
                per.setIdDispositivo(rs.getInt("ingreso_idDispositivo"));
                per.setIdPeaje(rs.getInt("ingreso_idPeaje"));
                per.setFecha(rs.getDate("ingreso_fecha"));
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public Ingreso leerID(Ingreso per) throws Exception{
        
        Ingreso pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM ingreso WHERE ingreso_id = ?");
            st.setInt(1, per.getIdIngresos());
            rs = st.executeQuery();
            
            while (rs.next()) {
                pers = new Ingreso();
                pers.setIdIngresos(rs.getInt("ingreso_id"));
                pers.setIdPersona(rs.getInt("ingreso_idPersona"));
                pers.setIdDispositivo(rs.getInt("ingreso_idDispositivo"));
                pers.setIdPeaje(rs.getInt("ingreso_idPeaje"));
                pers.setFecha(rs.getDate("ingreso_fecha"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        
        return pers;
    }
    
    public void modificar(Ingreso per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE ingreso SET ingreso_idPersona = ?, ingreso_idDispositivo = ?, ingreso_idPeaje = ?, ingreso_fecha = ? "
                    + "                                             WHERE ingreso_id = ?");
            st.setInt(1, per.getIdPersona());
            st.setInt(2, per.getIdDispositivo());
            st.setInt(3, per.getIdPeaje());
            st.setDate(4, (java.sql.Date) per.getFecha());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void eliminarID(Ingreso per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM ingreso WHERE ingreso_id = ?");
            st.setInt(1, per.getIdIngresos());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
