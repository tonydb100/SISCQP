package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private Connection cn;
    
    public Connection getCn(){
        return cn;
    }
    
    public void setCn(Connection cn){
        this.cn = cn;
    }
    
    public void Conectar() throws ClassNotFoundException, SQLException{
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=siscqp;user=sa;password=1630");
        
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siscqp?user=root&password=root");
    }
    
    public void cerrar() throws SQLException{
        if (cn != null){
            if (cn.isClosed() == false){
                cn.close();
            }
        } 
    }
    
}

