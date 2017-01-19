package Manejador;

import Datos.DatoIngreso_1;
import Modelo.Ingreso;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorIngreso_1 {
    
    private Ingreso ingreso = new Ingreso();
    private List<Ingreso> lstIngreso;
    
    private Date   ingreso_fecha = new Date();
    private String ingreso_dependencia;
    private String ingreso_operador;
    private String ingreso_dispositivo;
    private String ingreso_equipo;
    private String ingreso_placa;
    private Date   ingreso_fechaIngreso = new Date();
    private String ingreso_peaje;
    private String ingreso_sentido;
    private int    ingreso_monto;

    public Date getIngreso_fecha() {
        return ingreso_fecha;
    }

    public void setIngreso_fecha(Date ingreso_fecha) {
        this.ingreso_fecha = ingreso_fecha;
    }

    public String getIngreso_dependencia() {
        return ingreso_dependencia;
    }

    public void setIngreso_dependencia(String ingreso_dependencia) {
        this.ingreso_dependencia = ingreso_dependencia;
    }

    public String getIngreso_operador() {
        return ingreso_operador;
    }

    public void setIngreso_operador(String ingreso_operador) {
        this.ingreso_operador = ingreso_operador;
    }

    public String getIngreso_dispositivo() {
        return ingreso_dispositivo;
    }

    public void setIngreso_dispositivo(String ingreso_dispositivo) {
        this.ingreso_dispositivo = ingreso_dispositivo;
    }

    public String getIngreso_equipo() {
        return ingreso_equipo;
    }

    public void setIngreso_equipo(String ingreso_equipo) {
        this.ingreso_equipo = ingreso_equipo;
    }

    public String getIngreso_placa() {
        return ingreso_placa;
    }

    public void setIngreso_placa(String ingreso_placa) {
        this.ingreso_placa = ingreso_placa;
    }

    public Date getIngreso_fechaIngreso() {
        return ingreso_fechaIngreso;
    }

    public void setIngreso_fechaIngreso(Date ingreso_fechaIngreso) {
        this.ingreso_fechaIngreso = ingreso_fechaIngreso;
    }

    public String getIngreso_peaje() {
        return ingreso_peaje;
    }

    public void setIngreso_peaje(String ingreso_peaje) {
        this.ingreso_peaje = ingreso_peaje;
    }

    public String getIngreso_sentido() {
        return ingreso_sentido;
    }

    public void setIngreso_sentido(String ingreso_sentido) {
        this.ingreso_sentido = ingreso_sentido;
    }

    public int getIngreso_monto() {
        return ingreso_monto;
    }

    public void setIngreso_monto(int ingreso_monto) {
        this.ingreso_monto = ingreso_monto;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public List<Ingreso> getLstIngreso() {
        return lstIngreso;
    }

    public void setLstIngreso(List<Ingreso> lstIngreso) {
        this.lstIngreso = lstIngreso;
    }
    
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
    
//    private void limpiar(){
//        this.ingreso.setIngreso_monto(0);
//    }
    
    public void agregar(){
        Ingreso det = new Ingreso();
        det.setIngreso_fecha(ingreso_fecha);
        det.setIngreso_dependencia(ingreso_dependencia);
        det.setIngreso_operador(ingreso_operador);
        det.setIngreso_dispositivo(ingreso_dispositivo);
        det.setIngreso_equipo(ingreso_equipo);
        det.setIngreso_placa(ingreso_placa);
        det.setIngreso_fechaIngreso(ingreso_fechaIngreso);
        det.setIngreso_peaje(ingreso_peaje);
        det.setIngreso_sentido(ingreso_sentido);
        det.setIngreso_monto(ingreso_monto);
        this.lstIngreso.add(det);
    }
    
     public void registrar() throws Exception{
        DatoIngreso_1 dao;
        try {
            dao = new DatoIngreso_1();
            dao.registrar(ingreso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
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
////    
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
    
}
