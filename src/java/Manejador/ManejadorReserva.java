package Manejador;

import Modelo.Reserva;
import Datos.DatoReserva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorReserva {

    private Reserva reserva = new Reserva();
    private List<Reserva> lstReserva;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getLstReserva() {
        return lstReserva;
    }

    public void setLstReserva(List<Reserva> lstReserva) {
        this.lstReserva = lstReserva;
    }
    
    private boolean isPostBack(){
        boolean res;
        res = FacesContext.getCurrentInstance().isPostback();
        return res;
    }
   
    public void operar() throws Exception{
        
        switch(accion){
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
        }
    }
    
    private void limpiar(){
        this.reserva.setReserva_codigo(0);
        this.reserva.setReserva_montoRestante(0.0);
        this.reserva.setReserva_descripcion("");
    }
    
    private void registrar() throws Exception{
        
        DatoReserva dao;
        
        try {
            dao = new DatoReserva();
            dao.registrar(reserva);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoReserva dao;
        
        try {
            dao = new DatoReserva();
            dao.modificar(reserva);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar(String valor) throws Exception{
        
        DatoReserva dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoReserva();
                    lstReserva = dao.listar();
                }
            }else{
                dao = new DatoReserva();
                lstReserva = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void leerID(Reserva per) throws Exception{
        
        DatoReserva dao;
        Reserva temp;
        
        try {
            dao = new DatoReserva();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.reserva = temp;
                this.accion = "Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Reserva per) throws Exception{
        
        DatoReserva dao;
        
        try {
            dao = new DatoReserva();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
