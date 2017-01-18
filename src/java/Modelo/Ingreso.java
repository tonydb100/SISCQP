package Modelo;

import java.util.Date;

public class Ingreso {

    private int    ingreso_id;
    private Date   ingreso_fecha = new Date();
    private String ingreso_dependencia;
    private String ingreso_operador;
    private String ingreso_dispositivo;
    private String ingreso_equipo;
    private String ingreso_placa;
    private Date   ingreso_fechaIngreso = new Date();
    private String ingreso_peaje;
    private String ingreso_sentido;
    private int    ingreso_monto;

    public int getIngreso_id() {
        return ingreso_id;
    }

    public void setIngreso_id(int ingreso_id) {
        this.ingreso_id = ingreso_id;
    }

    public Date getIngreso_fecha() {
        java.sql.Date sqlDate = new java.sql.Date(ingreso_fecha.getTime());
        return sqlDate;
    }

    public void setIngreso_fecha(Date ingreso_fecha) {
        this.ingreso_fecha = ingreso_fecha;
    }

    public String getIngreso_dependencia() {
        return ingreso_dependencia;
    }

    public void setIngreso_dependencia(String ingreso_dependencia) {
        this.ingreso_dependencia = ingreso_dependencia.toUpperCase();
    }

    public String getIngreso_operador() {
        return ingreso_operador;
    }

    public void setIngreso_operador(String ingreso_operador) {
        this.ingreso_operador = ingreso_operador.toUpperCase();
    }

    public String getIngreso_dispositivo() {
        return ingreso_dispositivo;
    }

    public void setIngreso_dispositivo(String ingreso_dispositivo) {
        this.ingreso_dispositivo = ingreso_dispositivo.toUpperCase();
    }

    public String getIngreso_equipo() {
        return ingreso_equipo;
    }

    public void setIngreso_equipo(String ingreso_equipo) {
        this.ingreso_equipo = ingreso_equipo.toUpperCase();
    }

    public String getIngreso_placa() {
        return ingreso_placa;
    }

    public void setIngreso_placa(String ingreso_placa) {
        this.ingreso_placa = ingreso_placa.toUpperCase();
    }

    public Date getIngreso_fechaIngreso() {
        java.sql.Date sqlDate = new java.sql.Date(ingreso_fechaIngreso.getTime());
        return sqlDate;
    }

    public void setIngreso_fechaIngreso(Date ingreso_fechaIngreso) {
        this.ingreso_fechaIngreso = ingreso_fechaIngreso;
    }

    public String getIngreso_peaje() {
        return ingreso_peaje;
    }

    public void setIngreso_peaje(String ingreso_peaje) {
        this.ingreso_peaje = ingreso_peaje.toUpperCase();
    }

    public String getIngreso_sentido() {
        return ingreso_sentido;
    }

    public void setIngreso_sentido(String ingreso_sentido) {
        this.ingreso_sentido = ingreso_sentido.toUpperCase();
    }

    public int getIngreso_monto() {
        return ingreso_monto;
    }

    public void setIngreso_monto(int ingreso_monto) {
        this.ingreso_monto = ingreso_monto;
    }

}
