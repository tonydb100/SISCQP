package Manejador;

import Modelo.Personas;
import Datos.DatosPersonas;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ManejadorPersona {

    private Personas persona = new Personas();
    private List<Personas> lstPersonas;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public List<Personas> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Personas> lstPersonas) {
        this.lstPersonas = lstPersonas;
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
//                this.modificar();
//                this.limpiar();
                break;
        }
    }
    
    private void limpiar(){
        this.persona.setNombre("");
        this.persona.setApellidos("");
        this.persona.setCedula("");
        this.persona.setFoto("");
        this.persona.setRol(1);
        this.persona.setDepartamento("");
        this.persona.setPuesto("");
        this.persona.setJefeDirecto("");
    }
    
    private void registrar() throws Exception{
        
        DatosPersonas dp;
        
        try {
            dp = new DatosPersonas();
            dp.registrar(persona);
//            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
//    private void modificar() throws Exception{
//        
//        DatosPersonas dp;
//        
//        try {
//            dp = new DatosPersonas();
//            dp.modificar(persona);
//            this.listar("V");
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
//    public void listar(String valor) throws Exception{
//        
//        DatosPersonas dp;
//        
//        try {
//            if(valor.equals("F")){
//                if(isPostBack() == false){
//                    dp = new DatosPersonas();
//                    lstPersonas = dp.listar();
//                }
//            }else{
//                    dp = new DatosPersonas();
//                    lstPersonas = dp.listar();
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        
//    }
    
//    public void leerID(Persona per) throws Exception{
//        
//        DatosPersonas dp;
//        Persona temp;
//        
//        try {
//            dp = new DatosPersonas();
//            temp = dp.leerID(per);
//            
//            if (temp != null) {
//                this.persona = temp;
//                this.accion = "Modificar";
//            }
//            
//        } catch (Exception e) {
//            throw e;
//        }
//        
//    }
//    
//    public void eliminar(Persona per) throws Exception{
//        
//        DatosPersonas dp;
//        
//        try {
//            dp = new DatosPersonas();
//            dp.eliminarID(per);
//            this.listar("V");
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
}
