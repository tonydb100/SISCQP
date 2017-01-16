package Manejador;

import Datos.DatoPago;
import Modelo.Ingreso;
import Modelo.Peaje;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
   
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
    private Date date10;
     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public Date getDate10() {
        return date10;
    }

    public void setDate10(Date date10) {
        this.date10 = date10;
    }
    
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
        this.ingreso.setIngreso_peaje("");
        this.ingreso.setIngreso_sentido("");
        this.ingreso.setIngreso_monto(0);
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
