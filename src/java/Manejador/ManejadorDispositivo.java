package Manejador;

import Datos.DatoDispositivo;
import Modelo.Ingreso;
import Modelo.Dispositivo;
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
public class ManejadorDispositivo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Ingreso ingreso = new Ingreso();
    private Dispositivo dispositivo = new Dispositivo();
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
    
    public void NumeroTarjeta(){
        DatoDispositivo dao = new DatoDispositivo();
        dao.getTarjetaNumero();
    }
    
    public void PeriodoCobro(){
        DatoDispositivo dao = new DatoDispositivo();
        dao.getPeriodoCobro();
    }
    
    public void NumeroFactura(){
        DatoDispositivo dao = new DatoDispositivo();
        dao.getFacturaNumero();
    }
    
    @SuppressWarnings("unchecked")
    public void MontoFactura(){
        DatoDispositivo dao = new DatoDispositivo();
        dao.getMontoFactura();
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
        
        DatoDispositivo dao;
        
        try {
            dao = new DatoDispositivo();
            dao.registrar(ingreso);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoDispositivo dao;
        
        try {
            dao = new DatoDispositivo();
            dao.modificar(ingreso);
            this.listar("V");
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
                    lstIngreso = dao.listar();
                }
            }else{
                    dao = new DatoDispositivo();
                    lstIngreso = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void leerID(Ingreso per) throws Exception{
        
        DatoDispositivo dao;
        Ingreso temp;
        
        try {
            dao = new DatoDispositivo();
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
