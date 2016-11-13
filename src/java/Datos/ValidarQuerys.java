package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ValidarQuerys {
    
    
    private Connection cn;
    
    public Connection getCn(){
        return cn;
    }
    
    public void setCn(Connection cn){
        this.cn = cn;
    }
    
    public void Conectar() throws ClassNotFoundException, SQLException{
        Class.forName(Conexion.driver());
        cn = DriverManager.getConnection(Conexion.cadena(), Conexion.user(), Conexion.pass());
    }
    
    public void cerrar() throws SQLException{
        if (cn != null){
            if (cn.isClosed() == false){
                cn.close();
            }
        } 
    }
}
