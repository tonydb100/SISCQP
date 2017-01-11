package Manejador;

import Datos.DatoPersona;
import Modelo.pruebaIngreso;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorPruebaIngreso {
    
    private Date fecha;
    private Date fechaIngreso;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

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
    
    public void agregar(){
//         st.setInt(1, per.getIdPersona());
        pruebaIngreso PI = new pruebaIngreso();
        List<pruebaIngreso> lista = new ArrayList();
        
        for (int i = 0; i < lista.size(); i++) {
            PI[i].getFecha();
        }
        
        
    }
    
    public void listar(String valor) throws Exception{
        
        DatoPersona dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoPersona();
                    lstPersona = dao.listar();
                }
            }else{
                    dao = new DatoPersona();
                    lstPersona = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
