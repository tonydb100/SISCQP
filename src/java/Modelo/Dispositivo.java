package Modelo;

import java.util.Date;

public class Dispositivo {

    private int id;
    private String placaVehiculo;
    private int tarjetaAsociada;
    private Date fechaCompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public long getTarjetaAsociada() {
        return tarjetaAsociada;
    }

    public void setTarjetaAsociada(int tarjetaAsociada) {
        this.tarjetaAsociada = tarjetaAsociada;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    
    
}
