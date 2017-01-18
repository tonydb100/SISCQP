package Datos;

import Modelo.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatoReserva extends Conexion {
   
    public void registrar(Reserva per) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO reserva (reserva_codigo, reserva_montoRestante, "
                    + "reserva_descripcion) values (?,?,?)");
            st.setInt(1, per.getReserva_codigo());
            st.setDouble(2, per.getReserva_montoRestante());
            st.setString(3, per.getReserva_descripcion());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Reserva> listar() throws Exception{
        
        List<Reserva> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM reserva");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {                
                Reserva per = new Reserva();
                per.setReserva_id(rs.getInt("reserva_id"));
                per.setReserva_codigo(rs.getInt("reserva_codigo"));
                per.setReserva_montoRestante(rs.getDouble("reserva_montoRestante"));
                per.setReserva_descripcion(rs.getString("reserva_descripcion"));
                
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public Reserva leerID(Reserva per) throws Exception{
        
        Reserva pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM reserva WHERE reserva_id = ?");
            st.setInt(1, per.getReserva_id());
            rs = st.executeQuery();
            
            while (rs.next()) {
                pers = new Reserva();
                pers.setReserva_id(rs.getInt("reserva_id"));
                pers.setReserva_codigo(rs.getInt("reserva_codigo"));
                pers.setReserva_montoRestante(rs.getDouble("Reserva_montoRestante"));
                pers.setReserva_descripcion(rs.getString("Reserva_descripcion"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        
        return pers;
    }
    
    public void modificar(Reserva per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE reserva SET reserva_codigo = ?, reserva_montoRestante = ?, "
                    + "reserva_descripcion = ? WHERE reserva_id = ?");
            st.setInt(1, per.getReserva_codigo());
            st.setDouble(2, per.getReserva_montoRestante());
            st.setString(3, per.getReserva_descripcion());
            st.setInt(4, per.getReserva_id());
            
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void eliminarID(Reserva per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM reserva WHERE reserva_id = ?");
            st.setInt(1, per.getReserva_id());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
