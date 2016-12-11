package Modelo;

public class Peajes {

    private int idPeaje;
    private String nombre;
    private String sentido;
    private String tipoVehiculo;
    private int monto;

    public int getIdPeaje() {
        return idPeaje;
    }

    public void setIdPeaje(int idPeaje) {
        this.idPeaje = idPeaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
   
}
