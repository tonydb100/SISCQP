package Manejador;

import Datos.DatoDispositivo;
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
    private Dispositivo dispositivo = new Dispositivo();
    private List<Dispositivo> lstDispositivo;
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

    public List<Dispositivo> getLstIngreso() {
        return lstDispositivo;
    }

    public void setLstIngreso(List<Dispositivo> lstIngreso) {
        this.lstDispositivo = lstIngreso;
    }
    
    
    public void NombreOperador(){
        DatoDispositivo dao = new DatoDispositivo();
//        dao.();
    }
    
    public void CedulaOperador(){
        DatoDispositivo dao = new DatoDispositivo();
//        dao.();
    }
    
    @SuppressWarnings("unchecked")
    public void NumeroEquipo(){
        DatoDispositivo dao = new DatoDispositivo();
//        dao.();
    }
    
    @SuppressWarnings("unchecked")
    public void NumeroPlaca(){
        DatoDispositivo dao = new DatoDispositivo();
//        dao.();
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