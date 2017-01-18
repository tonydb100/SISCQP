package Manejador;

import Modelo.Persona;
import Datos.DatoPersona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ManejadorPersona {

    private Persona persona = new Persona();
    private List<Persona> lstPersona;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
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
        this.persona.setCedula("");
        this.persona.setNombre("");
        this.persona.setApellidos("");
        this.persona.setFoto("");
        this.persona.setRol(0);
        this.persona.setDepartamento("");
        this.persona.setPuesto("");
        this.persona.setJefeDirecto("");
        this.persona.setEstado(1);
    }
    
    private void registrar() throws Exception{
        
        DatoPersona dao;
        
        try {
            dao = new DatoPersona();
            dao.registrar(persona);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        
        DatoPersona dao;
        
        try {
            dao = new DatoPersona();
            dao.modificar(persona);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
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
    
    public void leerID(Persona per) throws Exception{
        
        DatoPersona dao;
        Persona temp;
        
        try {
            dao = new DatoPersona();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.persona = temp;
                this.accion = "Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Persona per) throws Exception{
        
        DatoPersona dao;
        
        try {
            dao = new DatoPersona();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
