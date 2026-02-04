package org.example;

import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws JRException, SQLException, IOException {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateToFile("employee_report.pdf");


        /*byte[] pdfData = reportGenerator.generate();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=student_report.pdf")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(pdfData);*/

    }
}