package Modelo;

public class Reserva {

    private int reservas_id;
    private int reservas_codigo;
    private Double reservas_montoRestante;
    private String reservas_descripcion;

    public int getReservas_id() {
        return reservas_id;
    }

    public void setReservas_id(int reservas_id) {
        this.reservas_id = reservas_id;
    }

    public int getReservas_codigo() {
        return reservas_codigo;
    }

    public void setReservas_codigo(int reservas_codigo) {
        this.reservas_codigo = reservas_codigo;
    }

    public Double getReservas_montoRestante() {
        return reservas_montoRestante;
    }

    public void setReservas_montoRestante(Double reservas_montoRestante) {
        this.reservas_montoRestante = reservas_montoRestante;
    }

    public String getReservas_descripcion() {
        return reservas_descripcion;
    }

    public void setReservas_descripcion(String reservas_descripcion) {
        this.reservas_descripcion = reservas_descripcion;
    }

}
