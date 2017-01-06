package Manejador;

import Datos.DatoPago;
import Modelo.Ingreso;
import Modelo.Peaje;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
   
@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorPagos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Ingreso ingreso = new Ingreso();
    private Peaje peaje = new Peaje();
    private List<Ingreso> lstIngreso;
    private String accion;
    private String fechaFinal;

    public Peaje getPeaje() {
        return peaje;
    }

    public void setPeaje(Peaje peaje) {
        this.peaje = peaje;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso persona) {
        this.ingreso = persona;
    }

    public List<Ingreso> getLstIngreso() {
        return lstIngreso;
    }

    public void setLstIngreso(List<Ingreso> lstIngreso) {
        this.lstIngreso = lstIngreso;
    }
    
    public void NombrePeaje(){
        DatoPago dao = new DatoPago();
        dao.getPeajeNombre();
    }
    
    @SuppressWarnings("unchecked")
    public void SentidoPeaje(){
        DatoPago dao = new DatoPago();
        dao.getPeajeSentido();
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
        this.ingreso.setIdPersona(0);
        this.ingreso.setIdDispositivo(0);
        this.ingreso.setIdPeaje(0);
    }
    
    private void registrar() throws Exception{
        
        DatoPago dao;
        
        try {
            dao = new DatoPago();
            dao.registrar(ingreso);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoPago dao;
        
        try {
            dao = new DatoPago();
            dao.modificar(ingreso);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar(String valor) throws Exception{
        
        DatoPago dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoPago();
                    lstIngreso = dao.listar();
                }
            }else{
                    dao = new DatoPago();
                    lstIngreso = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void leerID(Ingreso per) throws Exception{
        
        DatoPago dao;
        Ingreso temp;
        
        try {
            dao = new DatoPago();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.ingreso = temp;
                this.accion = "Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Ingreso per) throws Exception{
        
        DatoPago dao;
        
        try {
            dao = new DatoPago();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
