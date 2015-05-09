package com.ground.jasperpdf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import com.itextpdf.text.pdf.PdfWriter;

public class JasperReportFill {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws JRException {
		InputStream inputStream = JasperReportFill.class.getResourceAsStream("/com/ground/jasperpdf/jasper_report_template.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		DataBeanList DataBeanList = new DataBeanList();
		ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", "List of Contacts");
		parameters.put("Author", "Prepared By Veeru");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

		if (jasperPrint != null) {

			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("C://pdf/sample_reportExport.pdf"));

			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			configuration.set128BitKey(true);
			configuration.setUserPassword("password11");
			configuration.setOwnerPassword("password");
			configuration.setEncrypted(true);
			configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);

			exporter.setConfiguration(configuration);
			exporter.exportReport();

			JasperExportManager.exportReportToPdfFile(jasperPrint, "C://pdf/sample_report.pdf");
			JasperExportManager.exportReportToHtmlFile(jasperPrint, "C://pdf/sample_report.html");

			JRXlsExporter XLSexporter = new JRXlsExporter();

			XLSexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			XLSexporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C://pdf/sample_report.xls");

			XLSexporter.exportReport();
		}

	}

}
