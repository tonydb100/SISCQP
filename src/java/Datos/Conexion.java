package Datos;

public class Conexion {
    
    private static final String user = "root";;
    private static final String pass = "root";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String cadena = "jdbc:mysql://localhost:3306/mydb";
    
    
    public static String user(){
        return user;
    }
    
    public static String pass(){
        return pass;
    }
    
    public static String driver(){
        return driver;
    }
    
    public static String cadena(){
        return cadena;
    }
    
}

