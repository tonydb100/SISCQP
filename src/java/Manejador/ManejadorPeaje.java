package Manejador;

import Modelo.Peaje;
import Datos.DatoPeaje;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorPeaje {

    private Peaje peaje = new Peaje();
    private List<Peaje> lstPeaje;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Peaje getPeaje() {
        return peaje;
    }

    public void setPeaje(Peaje peaje) {
        this.peaje = peaje;
    }

    public List<Peaje> getLstPeaje() {
        return lstPeaje;
    }

    public void setLstPeaje(List<Peaje> lstPeaje) {
        this.lstPeaje = lstPeaje;
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
        this.peaje.setPeaje_nombre("");
        this.peaje.setPeaje_sentido("");
        this.peaje.setPeaje_tipoVehiculo("");
        this.peaje.setPeaje_monto(0);
    }
    
    private void registrar() throws Exception{
        
        DatoPeaje dao;
        
        try {
            dao = new DatoPeaje();
            dao.registrar(peaje);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoPeaje dao;
        
        try {
            dao = new DatoPeaje();
            dao.modificar(peaje);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar(String valor) throws Exception{
        
        DatoPeaje dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoPeaje();
                    lstPeaje = dao.listar();
                }
            }else{
                dao = new DatoPeaje();
                lstPeaje = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void leerID(Peaje per) throws Exception{
        
        DatoPeaje dao;
        Peaje temp;
        
        try {
            dao = new DatoPeaje();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.peaje = temp;
                this.accion = "Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Peaje per) throws Exception{
        
        DatoPeaje dao;
        
        try {
            dao = new DatoPeaje();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
