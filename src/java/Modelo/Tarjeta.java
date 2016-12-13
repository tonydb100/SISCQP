package Modelo;

public class Tarjeta {

    private int idTarjetas;
    private String numeroTarjeta;
    private int idTarjetaHabiente;
    private int idReserva;

    public int getIdTarjetas() {
        return idTarjetas;
    }

    public void setIdTarjetas(int idTarjetas) {
        this.idTarjetas = idTarjetas;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getIdTarjetaHabiente() {
        return idTarjetaHabiente;
    }

    public void setIdTarjetaHabiente(int idTarjetaHabiente) {
        this.idTarjetaHabiente = idTarjetaHabiente;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
}
