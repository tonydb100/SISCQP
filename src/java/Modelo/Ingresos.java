package Modelo;

import java.util.Date;

public class Ingresos {

    private int idIngresos;
    private int idPersona;
    private int idDispositivo;
    private int idPeaje;
    private Date fecha;

    public int getIdIngresos() {
        return idIngresos;
    }

    public void setIdIngresos(int idIngresos) {
        this.idIngresos = idIngresos;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public int getIdPeaje() {
        return idPeaje;
    }

    public void setIdPeaje(int idPeaje) {
        this.idPeaje = idPeaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
