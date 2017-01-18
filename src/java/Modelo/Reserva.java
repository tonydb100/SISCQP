package Modelo;

public class Reserva {

    private int reserva_id;
    private int reserva_codigo;
    private Double reserva_montoRestante;
    private String reserva_descripcion;

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public int getReserva_codigo() {
        return reserva_codigo;
    }

    public void setReserva_codigo(int reserva_codigo) {
        this.reserva_codigo = reserva_codigo;
    }

    public Double getReserva_montoRestante() {
        return reserva_montoRestante;
    }

    public void setReserva_montoRestante(Double reserva_montoRestante) {
        this.reserva_montoRestante = reserva_montoRestante;
    }

    public String getReserva_descripcion() {
        return reserva_descripcion;
    }

    public void setReserva_descripcion(String reserva_descripcion) {
        this.reserva_descripcion = reserva_descripcion;
    }

}
