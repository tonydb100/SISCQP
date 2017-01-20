package Manejador;

import Datos.DatoIngreso;
import Modelo.Ingreso;

import com.lowagie.text.PageSize;
import org.w3c.dom.Document;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import org.w3c.dom.Document;

@ManagedBean
@ViewScoped
@SessionScoped
public class ManejadorIngreso {
    
    private Ingreso ingreso = new Ingreso();
    private List<Ingreso> lstIngreso;
    
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
    
    
    private boolean isPostBack(){
        boolean res;
        res = FacesContext.getCurrentInstance().isPostback();
        return res;
    }
    
    public void limpiar(){
        this.ingreso.setIngreso_monto(0);
    }
    
    public void generarExcel(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
 
        for (org.apache.poi.ss.usermodel.Row row : sheet) {
            for (org.apache.poi.ss.usermodel.Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }
    
//    public void generarPdf(Object document) {
//      Document pdf = (Document) document;
//      pdf.setPageSize(PageSize.A4);
//      pdf.open();
//    }
    
    public void registrar() throws Exception{
        DatoIngreso dao;
        try {
            dao = new DatoIngreso();
            dao.registrar(ingreso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    private void modificar() throws Exception{
        
        DatoIngreso dao;
        
        try {
            dao = new DatoIngreso();
            dao.modificar(ingreso);
            this.listar("V");
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
 
    public void listar(String valor) throws Exception{
        
        DatoIngreso dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack() == false){
                    dao = new DatoIngreso();
                    lstIngreso = dao.listar();
                }
            }else{
                    dao = new DatoIngreso();
                    lstIngreso = dao.listar();
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
  
    public void leerID(Ingreso per) throws Exception{
        
        DatoIngreso dao;
        Ingreso temp;
        
        try {
            dao = new DatoIngreso();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.ingreso = temp;
                this.modificar();
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(Ingreso per) throws Exception{
        
        DatoIngreso dao;
        
        try {
            dao = new DatoIngreso();
            dao.eliminarID(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
