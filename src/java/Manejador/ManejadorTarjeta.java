package Manejador;

import Datos.DatoTarjeta;
import Modelo.Tarjeta;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
   
@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorTarjeta implements Serializable {
    
    private Tarjeta tarjeta = new Tarjeta();
    private List<Tarjeta> lstTarjeta;
     
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Tarjeta> getLstTarjeta() {
        return lstTarjeta;
    }

    public void setlstTarjeta(List<Tarjeta> lstTarjeta) {
        this.lstTarjeta = lstTarjeta;
    }
    
    private boolean isPostBack(){
        boolean res;
        res = FacesContext.getCurrentInstance().isPostback();
        return res;
    }
   
    private void limpiar(){
        this.tarjeta.setTarjeta_operador("");
        this.tarjeta.setTarjeta_cedulaOperador("");
        this.tarjeta.setTarjeta_numeroEquipo("");
        this.tarjeta.setTarjeta_numeroPlaca("");
    }
    
    public void registrar() throws Exception{
        
        DatoTarjeta dao;
        try {
            dao = new DatoTarjeta();
            dao.registrar(tarjeta);
            this.listar("V");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Error"));
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoTarjeta dao;
        try {
            dao = new DatoTarjeta();
            dao.modificar(tarjeta);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar(String valor) throws Exception{
        
        DatoTarjeta dao;
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoTarjeta();
                    lstTarjeta = dao.listar();
                }
            }else{
                    dao = new DatoTarjeta();
                    lstTarjeta = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void leerID(Tarjeta per) throws Exception{
        
        DatoTarjeta dao;
        Tarjeta temp;
        try {
            dao = new DatoTarjeta();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.tarjeta = temp;
                this.modificar();
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Tarjeta per) throws Exception{
        
        DatoTarjeta dao;
        try {
            dao = new DatoTarjeta();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
