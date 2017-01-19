package Manejador;

import Datos.DatoIngreso;
import Modelo.Ingreso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorIngreso {
//    
//    private Ingreso ingreso = new Ingreso();
//    private List<Ingreso> lstIngreso;
//    private String accion;
//
//    public String getAccion() {
//        return accion;
//    }
//
//    public void setAccion(String accion) {
////        this.limpiar();
//        this.accion = accion;
//    }
//
//    public Ingreso getIngreso() {
//        return ingreso;
//    }
//
//    public void setIngreso(Ingreso ingreso) {
//        this.ingreso = ingreso;
//    }
//
//    public List<Ingreso> getLstIngreso() {
//        return lstIngreso;
//    }
//
//    public void setLstIngreso(List<Ingreso> lstIngreso) {
//        this.lstIngreso = lstIngreso;
//    }
//
//    private boolean isPostBack(){
//        boolean res;
//        res = FacesContext.getCurrentInstance().isPostback();
//        return res;
//    }
//   
//    public void operar() throws Exception{
//        
//        switch(accion){
//            case "Registrar":
//                this.registrar();
//                this.limpiar();
//                break;
//            case "Modificar":
//                this.modificar();
//                this.limpiar();
//                break;
//        }
//    }
//    
//    private void limpiar(){
//        this.ingreso.setIngreso_monto(0);
//    }
//    
//    public void registrar() throws Exception{
//        
//        DatoIngreso dao;
//        
//        try {
//            dao = new DatoIngreso();
//            dao.registrar(ingreso);
//            this.listar("V");
//            this.limpiar();
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    
//    public void modificar() throws Exception{
//        
//        DatoIngreso dao;
//        
//        try {
//            dao = new DatoIngreso();
//            dao.modificar(ingreso);
//            this.listar("V");
//            this.limpiar();
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    
//    public void listar(String valor) throws Exception{
//        
//        DatoIngreso dao;
//        
//        try {
//            if(valor.equals("F")){
//                if(isPostBack() == false){
//                    dao = new DatoIngreso();
//                    lstIngreso = dao.listar();
//                }
//            }else{
//                    dao = new DatoIngreso();
//                    lstIngreso = dao.listar();
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        
//    }
//    
//    public void leerID(Ingreso per) throws Exception{
//        
//        DatoIngreso dao;
//        Ingreso temp;
//        
//        try {
//            dao = new DatoIngreso();
//            temp = dao.leerID(per);
//            
//            if (temp != null) {
//                this.ingreso = temp;
//                this.accion = "Modificar";
//            }
//            
//        } catch (Exception e) {
//            throw e;
//        }
//        
//    }
//    
//    public void eliminar(Ingreso per) throws Exception{
//        
//        DatoIngreso dao;
//        
//        try {
//            dao = new DatoIngreso();
//            dao.eliminarID(per);
//            this.listar("V");
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    
}
