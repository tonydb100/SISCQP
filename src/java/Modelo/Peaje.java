package Modelo;

public class Peaje {

    private int peaje_id;
    private String peaje_nombre;
    private String peaje_sentido;
    private String peaje_tipoVehiculo;
    private int peaje_monto;

    public int getPeaje_id() {
        return peaje_id;
    }

    public void setPeaje_id(int peaje_id) {
        this.peaje_id = peaje_id;
    }

    public String getPeaje_nombre() {
        return peaje_nombre;
    }

    public void setPeaje_nombre(String peaje_nombre) {
        this.peaje_nombre = peaje_nombre;
    }

    public String getPeaje_sentido() {
        return peaje_sentido;
    }

    public void setPeaje_sentido(String peaje_sentido) {
        this.peaje_sentido = peaje_sentido;
    }

    public String getPeaje_tipoVehiculo() {
        return peaje_tipoVehiculo;
    }

    public void setPeaje_tipoVehiculo(String peaje_tipoVehiculo) {
        this.peaje_tipoVehiculo = peaje_tipoVehiculo;
    }

    public int getPeaje_monto() {
        return peaje_monto;
    }

    public void setPeaje_monto(int peaje_monto) {
        this.peaje_monto = peaje_monto;
    }

}
