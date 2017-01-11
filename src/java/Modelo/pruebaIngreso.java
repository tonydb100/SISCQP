package Modelo;

import java.util.Date;

public class pruebaIngreso {
    
    private Date fecha;
    private String dependencia;
    private String operador;
    private String numeroDispositivo;
    private String numeroEquipo;
    private String numeroPlaca;
    private Date fechaIngreso;
    private String peaje;
    private String sentido;
    private int monto;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getNumeroDispositivo() {
        return numeroDispositivo;
    }

    public void setNumeroDispositivo(String numeroDispositivo) {
        this.numeroDispositivo = numeroDispositivo;
    }

    public String getNumeroEquipo() {
        return numeroEquipo;
    }

    public void setNumeroEquipo(String numeroEquipo) {
        this.numeroEquipo = numeroEquipo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPeaje() {
        return peaje;
    }

    public void setPeaje(String peaje) {
        this.peaje = peaje;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
}
