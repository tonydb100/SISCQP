package Modelo;

import java.util.Date;

public class Dispositivo {

    private int dispositivo_id;
    private String dispositivo_reserva;
    private String dispositivo_codigo;
    private Date dispositivo_fechaCompra;
    private String dispositivo_registroContable;
    private String dispositivo_programaBCR;
    private String dispositivo_tarjeta;
    private String dispositivo_periodoCobro;
    private String dispositivo_factura;
    private double dispositivo_montoFacturas;

    public int getDispositivo_id() {
        return dispositivo_id;
    }

    public void setDispositivo_id(int dispositivo_id) {
        this.dispositivo_id = dispositivo_id;
    }

    public String getDispositivo_reserva() {
        return dispositivo_reserva;
    }

    public void setDispositivo_reserva(String dispositivo_reserva) {
        this.dispositivo_reserva = dispositivo_reserva;
    }

    public String getDispositivo_codigo() {
        return dispositivo_codigo;
    }

    public void setDispositivo_codigo(String dispositivo_codigo) {
        this.dispositivo_codigo = dispositivo_codigo;
    }

    public Date getDispositivo_fechaCompra() {
        return dispositivo_fechaCompra;
    }

    public void setDispositivo_fechaCompra(Date dispositivo_fechaCompra) {
        this.dispositivo_fechaCompra = dispositivo_fechaCompra;
    }

    public String getDispositivo_registroContable() {
        return dispositivo_registroContable;
    }

    public void setDispositivo_registroContable(String dispositivo_registroContable) {
        this.dispositivo_registroContable = dispositivo_registroContable;
    }

    public String getDispositivo_programaBCR() {
        return dispositivo_programaBCR;
    }

    public void setDispositivo_programaBCR(String dispositivo_programaBCR) {
        this.dispositivo_programaBCR = dispositivo_programaBCR;
    }

    public String getDispositivo_tarjeta() {
        return dispositivo_tarjeta;
    }

    public void setDispositivo_tarjeta(String dispositivo_tarjeta) {
        this.dispositivo_tarjeta = dispositivo_tarjeta;
    }

    public String getDispositivo_periodoCobro() {
        return dispositivo_periodoCobro;
    }

    public void setDispositivo_periodoCobro(String dispositivo_periodoCobro) {
        this.dispositivo_periodoCobro = dispositivo_periodoCobro;
    }

    public String getDispositivo_factura() {
        return dispositivo_factura;
    }

    public void setDispositivo_factura(String dispositivo_factura) {
        this.dispositivo_factura = dispositivo_factura;
    }

    public double getDispositivo_montoFacturas() {
        return dispositivo_montoFacturas;
    }

    public void setDispositivo_montoFacturas(double dispositivo_montoFacturas) {
        this.dispositivo_montoFacturas = dispositivo_montoFacturas;
    }
    
    
}
