//package Datos;
//
//import Modelo.Personas;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatosPersonas extends ValidarQuerys {
//   
//    public void registrar(Personas per) throws Exception{
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO personas (nombre, apellidos, cedula, foto, rol, "
//                                                                + "departamento, puesto, fechaRegistro, jefeDirecto, estado) "
//                                                                    + "values (?,?,?,?,?,?,?,?,?,?)");
//            st.setString(1, per.getNombre());
//            st.setString(2, per.getApellidos());
//            st.setString(3, per.getCedula());
//            st.setString(4, per.getFoto());
//            st.setInt(5, per.getRol());
//            st.setString(6, per.getDepartamento());
//            st.setString(7, per.getPuesto());
//            st.setDate(8, (Date) per.getFechaRegistro());
//            st.setString(9, per.getJefeDirecto());
//            st.setBoolean(10, per.isEstado());
//            st.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//    }
//    
//    public List<Personas> listar() throws Exception{
//        
//        List<Personas> lista;
//        ResultSet rs;
//        
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("SELECT nombre, apellidos, cedula, foto, rol, departamento, puesto, "
//                                                                    + "fechaRegistro, jefeDirecto, estado FROM personas");
//            rs = st.executeQuery();
//            lista = new ArrayList();
//            
//            while (rs.next()) {                
//                Personas per = new Personas();
//                per.setIdPersona(rs.getInt("idPersona"));
//                per.setNombre(rs.getString("nombre"));
//                per.setApellidos(rs.getString("apellidos"));
//                per.setCedula(rs.getString("cedula"));
//                per.setFoto(rs.getString("foto"));
//                per.setRol(rs.getInt("rol"));
//                per.setDepartamento(rs.getString("departamento"));
//                per.setPuesto(rs.getString("puesto"));
//                per.setFechaRegistro(rs.getDate("fechaRegistro"));
//                per.setJefeDirecto(rs.getString("jefeDirecto"));
//                per.setEstado(rs.getBoolean("estado"));
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
//    public Personas leerID(Personas per) throws Exception{
//        
//        Persona pers = null;
//        ResultSet rs;
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, sexo FROM persona WHERE codigo = ?");
//            st.setInt(1, per.getCodigo());
//            rs = st.executeQuery();
//            
//            while (rs.next()) {
//                pers = new Persona();
//                pers.setCodigo(rs.getInt("codigo"));
//                pers.setNombre(rs.getString("nombre"));
//                pers.setSexo(rs.getString("sexo"));
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
//    public void modificar(Persona per) throws Exception{
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("UPDATE persona SET nombre = ?, sexo = ? WHERE codigo = ?");
//            st.setString(1, per.getNombre());
//            st.setString(2, per.getSexo());
//            st.setInt(3, per.getCodigo());
//            st.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//    }
//    
//    public void eliminarID(Persona per) throws Exception{
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM persona WHERE codigo = ?");
//            st.setInt(1, per.getCodigo());
//            st.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//    }
//     
//}
