package Datos;

import Modelo.Persona;
import static com.sun.jndi.toolkit.dir.SearchFilter.format;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DatoPersona extends Conexion {
   
    public void registrar(Persona per) throws Exception{
        
        try {
            this.Conectar();
//        per.setFechaRegisto(this.obtenerHora());
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO persona (persona_cedula, persona_nombre, persona_apellidos, persona_foto, persona_rol, "
                            + "persona_departamento, persona_puesto, persona_fechaRegistro, persona_jefeDirecto, persona_estado) "
                            + "values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, per.getCedula());
            st.setString(2, per.getNombre());
            st.setString(3, per.getApellidos());
            st.setString(4, per.getFoto());
            st.setInt(5, per.getRol());
            st.setString(6, per.getDepartamento());
            st.setString(7, per.getPuesto());
            st.setString(8, per.getFechaRegisto());
            st.setString(9, per.getJefeDirecto());
            st.setInt(10, per.getEstado());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public String obtenerHora(){
        
        Calendar c = GregorianCalendar.getInstance();
        Date fecha = c.getTime();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        String fechaFinal = f.format(fecha);
        
        return fechaFinal;
    }
    
    public List<Persona> listar() throws Exception{
        
        List<Persona> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM persona");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {                
                Persona per = new Persona();
                per.setCodigo(rs.getInt("persona_id"));
                per.setCedula(rs.getString("persona_cedula"));
                per.setNombre(rs.getString("persona_nombre"));
                per.setApellidos(rs.getString("persona_apellidos"));
                per.setFoto(rs.getString("persona_foto"));
                per.setRol(rs.getInt("persona_rol"));
                per.setDepartamento(rs.getString("persona_departamento"));
                per.setPuesto(rs.getString("persona_puesto"));
                per.setFechaRegisto(rs.getString("persona_fechaRegistro"));
                per.setJefeDirecto(rs.getString("persona_jefeDirecto"));
                per.setEstado(rs.getInt("persona_estado"));
                
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public Persona leerID(Persona per) throws Exception{
        
        Persona pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM persona WHERE persona_id = ?");
            st.setInt(1, per.getCodigo());
            rs = st.executeQuery();
            
            while (rs.next()) {
                pers = new Persona();
                pers.setCodigo(rs.getInt("persona_id"));
                pers.setCedula(rs.getString("persona_cedula"));
                pers.setNombre(rs.getString("persona_nombre"));
                pers.setApellidos(rs.getString("persona_apellidos"));
                pers.setFoto(rs.getString("persona_foto"));
                pers.setRol(rs.getInt("persona_rol"));
                pers.setDepartamento(rs.getString("persona_departamento"));
                pers.setPuesto(rs.getString("persona_puesto"));
                pers.setFechaRegisto(rs.getString("persona_fecharegistro"));
                pers.setJefeDirecto(rs.getString("persona_jefedirecto"));
                pers.setEstado(rs.getInt("persona_estado"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        
        return pers;
    }
    
    public void modificar(Persona per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE persona SET persona_cedula = ?, persona_nombre = ?, persona_apellidos = ?, persona_foto = ?, persona_rol = ?, "
                            + "persona_departamento = ?, persona_puesto = ?, persona_fechaRegistro = ?, persona_jefeDirecto = ?, persona_estado = ? WHERE persona_codigo = ?");
            st.setString(1, per.getCedula());
            st.setString(2, per.getNombre());
            st.setString(3, per.getApellidos());
            st.setString(4, per.getFoto());
            st.setInt(5, per.getRol());
            st.setString(6, per.getDepartamento());
            st.setString(7, per.getPuesto());
            st.setString(8, per.getFechaRegisto());
            st.setString(9, per.getJefeDirecto());
            st.setInt(10, per.getEstado());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void eliminarID(Persona per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM persona WHERE persona_id = ?");
            st.setInt(1, per.getCodigo());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
