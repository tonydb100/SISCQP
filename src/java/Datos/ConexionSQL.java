package Datos;

public class ConexionSQL {

    private String servidor = "";
    private String puerto = "";
    private String usuario = "";
    private String clave = "";
    private String schema = "";

    public ConexionSQL() {
    
     servidor = "localhost";
     puerto = "1433";
     usuario = "sa";
     clave ="1234";
     schema = "DbSISCQP";        
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getServidor() {
        return servidor;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
