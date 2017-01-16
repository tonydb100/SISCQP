package Manejador;

//import com.lowagie.text.BadElementException;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.primefaces.component.export.ExcelOptions;
//import org.primefaces.component.export.PDFOptions;
import org.w3c.dom.Document;

@ManagedBean
public class ManejadorReportes implements Serializable {
//    
//    private List<Car> cars2;
//     
//    private ExcelOptions excelOpt;
//     
//    private PDFOptions pdfOpt;
//         
//    @ManagedProperty("#{carService}")
//    private CarService service;
//     
//    @PostConstruct
//    public void init() {
//        cars2 = service.createCars(100);
//        customizationOptions();
//    }
//     
//    public void customizationOptions() {
//        excelOpt = new ExcelOptions();
//        excelOpt.setFacetBgColor("#F88017");
//        excelOpt.setFacetFontSize("10");
//        excelOpt.setFacetFontColor("#0000ff");
//        excelOpt.setFacetFontStyle("BOLD");
//        excelOpt.setCellFontColor("#00ff00");
//        excelOpt.setCellFontSize("8");
//         
//        pdfOpt = new PDFOptions();
//        pdfOpt.setFacetBgColor("#F88017");
//        pdfOpt.setFacetFontColor("#0000ff");
//        pdfOpt.setFacetFontStyle("BOLD");
//        pdfOpt.setCellFontSize("12");
//    }
// 
//    public List<Car> getCars2() {
//        return cars2;
//    }
// 
//    public ExcelOptions getExcelOpt() {
//        return excelOpt;
//    }
// 
//    public void setExcelOpt(ExcelOptions excelOpt) {
//        this.excelOpt = excelOpt;
//    }
// 
//    public PDFOptions getPdfOpt() {
//        return pdfOpt;
//    }
// 
//    public void setPdfOpt(PDFOptions pdfOpt) {
//        this.pdfOpt = pdfOpt;
//    }
// 
//    public void setService(CarService service) {
//        this.service = service;
//    }
//     
//    public void postProcessXLS(Object document) {
//        HSSFWorkbook wb = (HSSFWorkbook) document;
//        HSSFSheet sheet = wb.getSheetAt(0);
//        HSSFRow header = sheet.getRow(0);
//         
//        HSSFCellStyle cellStyle = wb.createCellStyle();  
//        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
//        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//         
//        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
//            HSSFCell cell = header.getCell(i);
//             
//            cell.setCellStyle(cellStyle);
//        }
//    }
//     
//    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
//        Document pdf = (Document) document;
//        pdf.open();
//        pdf.setPageSize(PageSize.A4);
// 
//        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";
//         
//        pdf.add(Image.getInstance(logo));
//    }
//    
    
    
}
