/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Exceptions.ControlEscolarException;
import Modelo.Alumnos;
import Modelo.Grupos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author cgarcia
 */
public class ReportesControlador extends ControladorBase {
    
    private static final String URL_REPORTES = "C:\\cobaez\\";
    private static final String REPORTE_ALUMNOS = "/reportes/Reporte_Alumnos.jasper";
    private static final String REPORTE_CARDEX = "/reportes/Reporte_Cardex.jasper";
    
    public ReportesControlador() {
        super();
    }
    
    public void exportarAlumnos(Grupos gpo) throws ControlEscolarException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("logo", getLogo());
        parametros.put("grupo", gpo.getSemestre() + " " +gpo.getGrupo());
        parametros.put("idGrupo", gpo.getIdGrupo());
        
        String nombrePdf = URL_REPORTES + "Lista_" + gpo.getSemestre() + " " + gpo.getGrupo() + ".pdf";
        
        exportar(REPORTE_ALUMNOS, parametros, nombrePdf);
        abrirPdf(nombrePdf);
    }
    
    public void exportarCalificaciones(Alumnos al) throws ControlEscolarException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("logo", getLogo());
        parametros.put("grupo", al.getGrupo().getSemestre() + " " +al.getGrupo().getGrupo());
        parametros.put("idGrupo", al.getGrupo().getIdGrupo());
        parametros.put("idAlumno", al.getIdAlumno());
        parametros.put("alumno", al.getNombre() + " " + al.getApepaterno() + " " + al.getApematerno());
        
        String nombrePdf = URL_REPORTES + "Cardex_" + parametros.get("alumno") + ".pdf";
        
        exportar(REPORTE_CARDEX, parametros, nombrePdf);
        abrirPdf(nombrePdf);
    }
    
    private void abrirPdf(String nombrePdf) {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + nombrePdf);
        } catch(IOException ex) {
            
        }
    }
    
    private void exportar(String nombreReporte, Map<String, Object> parametros, String nombrePdf) throws ControlEscolarException {
        try {
            InputStream reporte = ReportesControlador.class.getResourceAsStream(nombreReporte);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(reporte, parametros, getConnection());
            File archivo = new File(nombrePdf);
            archivo.createNewFile();
            JasperExportManager.exportReportToPdfFile(jp, nombrePdf);
        } catch (Exception ex) {
            throw new ControlEscolarException("No se pudo generar el reporte debido a: " + ex.getMessage());
        }
    }
    
    private InputStream getLogo() {
        return ReportesControlador.class.getResourceAsStream("/reportes/logo_cobaez.jpg");
    }
}
