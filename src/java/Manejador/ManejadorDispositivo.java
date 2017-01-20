package Manejador;

import Datos.DatoDispositivo;
import Modelo.Dispositivo;
import java.util.List;
import javax.faces.application.FacesMessage;
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
     
    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
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
   
    private void limpiar(){
        this.dispositivo.setDispositivo_tarjeta("");
        this.dispositivo.setDispositivo_periodoCobro("");
        this.dispositivo.setDispositivo_factura("");
        this.dispositivo.setDispositivo_montoFacturas(0);
    }
    
    public void registrar() throws Exception{
        
        DatoDispositivo dao;
        try {
            dao = new DatoDispositivo();
            dao.registrar(dispositivo);
            this.listar("V");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Error"));
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
                this.modificar();
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
