package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ValidarQuerysSQL {
    
    private Connection sqlconn = null;
    private String msgError = "";
    private ConexionSQL cnx = null;
    
    public ValidarQuerysSQL(){
        sqlconn = null;
        msgError = "";
        cnx = new ConexionSQL();
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String MsgError) {
        this.msgError = MsgError;
    }

    public Connection getSqlconn() {
        return sqlconn;
    }

    public void setSqlconn(Connection sqlconn) {
        this.sqlconn = sqlconn;
    }

    public void conectar() {
        this.conectar(cnx.getServidor(), cnx.getPuerto(), cnx.getUsuario(), cnx.getClave(), cnx.getSchema());
    }

    public boolean conectar(String servidor, String puerto, String usuario, String clave, String schema) {
        try{
            //Class.forName("com.ibm.db2.jcc.DB2Driver");
            //sqlconn = DriverManager.getConnection("jdbc:db2://" + servidor + ":"+ puerto +"/" + schema, usuario, clave);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
            //String connectionUrl = "jdbc:sqlserver://"+servidor+":"+puerto+";" +
            String connectionUrl = "jdbc:sqlserver://"+servidor+":"+puerto+";"+
            "databaseName="+schema+";user="+usuario+";password="+clave+";";
            //sqlconn = DriverManager.getConnection("jdbc:sqlserver://"+servidor+":"+puerto+";databaseName="+schema+";user="+usuario+";password="+clave+";");
            sqlconn= DriverManager.getConnection(connectionUrl);
            return true;
        } catch(ClassNotFoundException cnfe) {
            this.setMsgError(cnfe.getMessage());
        } catch(SQLException sqle) {
            this.setMsgError(sqle.getMessage());
        }
        return false;
    }

    public void desconectar() {
        try {
            if(sqlconn != null)
                sqlconn.close();
            sqlconn = null;
        } catch(Exception e) {
            this.setMsgError(e.getMessage());
        }
    }
}
