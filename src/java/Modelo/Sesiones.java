package Modelo;

import java.util.Date;

public class Sesiones {

    private int idSesiones;
    private int idPersona;
    private Date ingreso;
    private Date salida;

    public int getIdSesiones() {
        return idSesiones;
    }

    public void setIdSesiones(int idSesiones) {
        this.idSesiones = idSesiones;
    }
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }
    
}
