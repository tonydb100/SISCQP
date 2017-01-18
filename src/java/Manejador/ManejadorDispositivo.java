package Manejador;

import Datos.DatoDispositivo;
import Modelo.Dispositivo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
   
@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorDispositivo {
    
    private Dispositivo dispositivo = new Dispositivo();
    private List<Dispositivo> lstDispositivo;
    private String accion;
     
    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Dispositivo> getLstDispositivo() {
        return lstDispositivo;
    }

    public void setLstDispositivo(List<Dispositivo> lstDispositivo) {
        this.lstDispositivo = lstDispositivo;
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
        this.dispositivo.setDispositivo_tarjeta("");
        this.dispositivo.setDispositivo_periodoCobro("");
        this.dispositivo.setDispositivo_factura("");
        this.dispositivo.setDispositivo_montoFacturas(0);
    }
    
    private void registrar() throws Exception{
        
        DatoDispositivo dao;
        
        try {
            dao = new DatoDispositivo();
            dao.registrar(dispositivo);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoDispositivo dao;
        
        try {
            dao = new DatoDispositivo();
            dao.modificar(dispositivo);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar(String valor) throws Exception{
        
        DatoDispositivo dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoDispositivo();
                    lstDispositivo = dao.listar();
                }
            }else{
                dao = new DatoDispositivo();
                lstDispositivo = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void leerID(Dispositivo per) throws Exception{
        
        DatoDispositivo dao;
        Dispositivo temp;
        
        try {
            dao = new DatoDispositivo();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.dispositivo = temp;
                this.accion = "Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Dispositivo per) throws Exception{
        
        DatoDispositivo dao;
        
        try {
            dao = new DatoDispositivo();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
 
}
