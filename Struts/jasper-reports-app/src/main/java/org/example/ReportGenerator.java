package org.example;

import net.sf.jasperreports.engine.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    public void generateToFile(String fileName) throws JRException, SQLException {
        // 2. Compile JRXML to Jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/employee_report.jrxml"));
        // 3. Parameters (optional)
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Admin");


        // 4. Fill report with DB data
        try (Connection c = getConnection()) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, c);

            // 5. Export to PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
            //JasperExportManager.exportReportToPdfStream();

            System.out.println("Report generated successfully!");
        }
    }

    public byte[] generate() throws JRException, SQLException, IOException {
        // 2. Compile JRXML to Jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/employee_report.jrxml"));
        // 3. Parameters (optional)
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Admin");

        // 4. Fill report with DB data
        try (Connection c = getConnection()) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, c);

            // 5. Export to PDF
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                System.out.println("byte[] Report generated successfully!");
                return out.toByteArray();
            }
        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/jasper_reports?serverTimezone=UTC", "root", "11111111");
    }
}
