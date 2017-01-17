package Manejador;

import Datos.DatoTarjeta;
import Modelo.Tarjeta;
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
public class ManejadorTarjeta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Tarjeta tarjeta = new Tarjeta();
    private List<Tarjeta> lstTarjeta;
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
    
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Tarjeta> getLstIngreso() {
        return lstTarjeta;
    }

    public void setLstIngreso(List<Tarjeta> lstIngreso) {
        this.lstTarjeta = lstIngreso;
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
        this.tarjeta.setTarjeta_operador("");
        this.tarjeta.setTarjeta_cedulaOperador("");
        this.tarjeta.setTarjeta_numeroEquipo("");
        this.tarjeta.setTarjeta_numeroPlaca("");
    }
    
    private void registrar() throws Exception{
        
        DatoTarjeta dao;
        
        try {
            dao = new DatoTarjeta();
            dao.registrar(tarjeta);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoTarjeta dao;
        
        try {
            dao = new DatoTarjeta();
            dao.modificar(tarjeta);
            this.listar("V");
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
                this.accion = "Modificar";
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
