package Modelo;

import java.util.Date;

public class Sesion {

    private int sesion_id;
    private int sesion_idPersona;
    private Date sesion_ingreso = new Date();
    private Date sesion_salida = new Date();

    public int getSesion_id() {
        return sesion_id;
    }

    public void setSesion_id(int sesion_id) {
        this.sesion_id = sesion_id;
    }

    public int getSesion_idPersona() {
        return sesion_idPersona;
    }

    public void setSesion_idPersona(int sesion_idPersona) {
        this.sesion_idPersona = sesion_idPersona;
    }

    public Date getSesion_ingreso() {
        java.sql.Date sqlDate = new java.sql.Date(sesion_ingreso.getTime());
        return sqlDate;
    }

    public void setSesion_ingreso(Date sesion_ingreso) {
        this.sesion_ingreso = sesion_ingreso;
    }

    public Date getSesion_salida() {
        java.sql.Date sqlDate = new java.sql.Date(sesion_salida.getTime());
        return sqlDate;
    }

    public void setSesion_salida(Date sesion_salida) {
        this.sesion_salida = sesion_salida;
    }

    
}
