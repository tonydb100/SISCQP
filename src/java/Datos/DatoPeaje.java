package Datos;

import Modelo.Peaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatoPeaje extends Conexion {
   
    public void registrar(Peaje per) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO peaje (peaje_nombre, peaje_sentido, "
                    + "peaje_tipoVehiculo, peaje_monto) values (?,?,?,?)");
            st.setString(1, per.getPeaje_nombre());
            st.setString(2, per.getPeaje_sentido());
            st.setString(3, per.getPeaje_tipoVehiculo());
            st.setInt(4, per.getPeaje_monto());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Peaje> listar() throws Exception{
        
        List<Peaje> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM peaje");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {                
                Peaje per = new Peaje();
                per.setPeaje_id(rs.getInt("peaje_id"));
                per.setPeaje_nombre(rs.getString("peaje_nombre"));
                per.setPeaje_sentido(rs.getString("peaje_sentido"));
                per.setPeaje_tipoVehiculo(rs.getString("peaje_tipoVehiculo"));
                per.setPeaje_monto(rs.getInt("peaje_monto"));
                
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public Peaje leerID(Peaje per) throws Exception{
        
        Peaje pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM peaje WHERE peaje_id = ?");
            st.setInt(1, per.getPeaje_id());
            rs = st.executeQuery();
            
            while (rs.next()) {
                pers = new Peaje();
                pers.setPeaje_id(rs.getInt("peaje_id"));
                pers.setPeaje_nombre(rs.getString("peaje_nombre"));
                pers.setPeaje_sentido(rs.getString("Peaje_sentido"));
                pers.setPeaje_tipoVehiculo(rs.getString("Peaje_tipoVehiculo"));
                pers.setPeaje_monto(rs.getInt("peaje_monto"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        
        return pers;
    }
    
    public void modificar(Peaje per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE peaje SET peaje_nombre = ?, peaje_sentido = ?, peaje_tipoVehiculo = ?, "
                    + "peaje_monto = ? WHERE peaje_id = ?");
            st.setString(1, per.getPeaje_nombre());
            st.setString(2, per.getPeaje_sentido());
            st.setString(3, per.getPeaje_tipoVehiculo());
            st.setInt(4, per.getPeaje_monto());
            st.setInt(5, per.getPeaje_id());
            
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void eliminarID(Peaje per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM peaje WHERE peaje_id = ?");
            st.setInt(1, per.getPeaje_id());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
