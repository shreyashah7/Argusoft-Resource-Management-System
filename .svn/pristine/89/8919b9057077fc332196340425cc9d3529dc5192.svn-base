/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.reports;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * For creating and downloading the reports
 *
 * @author shreya
 */
@ManagedBean
public class CreateAndDownloadReport {

    public void createReport(String fileName, String title, JRDataSource dataSource, String extension, TextColumnBuilder<?>... columns) throws DRException {
        System.out.println("insdie create and download");
        FacesContext facesContext = FacesContext.getCurrentInstance();

        JasperReportBuilder report = report();
        report.setTemplate(Templates.reportTemplate)
                .columns(columns)
                .title(Templates.createTitleComponent(title))
                .pageFooter(Templates.createFooterComponent())
                .setDataSource(dataSource)
                .setNoDataSplitType(SplitType.PREVENT)
                .setSummarySplitType(SplitType.PREVENT)
                .setDetailSplitType(SplitType.PREVENT);

        if (extension.equalsIgnoreCase(".html")) {
            System.out.println("insindet he html..............");
            report.toPdf(export.pdfExporter(facesContext.getExternalContext().getRealPath("/") + "/report" + ".pdf"));
            //report.toHtml(export.htmlExporter(facesContext.getExternalContext().getRealPath("/") + "/report"+extension));
        } else {
            if (extension.equalsIgnoreCase(".pdf")) {
                System.out.println("insindet he pdf..............");
                report.toPdf(export.pdfExporter(facesContext.getExternalContext().getRealPath("/") + "/report" + extension));
            } else if (extension.equalsIgnoreCase(".xls")) {
                System.out.println("insindet he xls..............");
                report.toXls(export.xlsExporter(facesContext.getExternalContext().getRealPath("/") + "/report" + extension)
                        .setDetectCellType(true)
                        .setIgnorePageMargins(true)
                        .setWhitePageBackground(false)
                        .setRemoveEmptySpaceBetweenColumns(true));
            }
            downloadGeneratedReport(fileName, extension);
        }
    }

    public void downloadGeneratedReport(String fileName, String extension) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        File file = new File(facesContext.getExternalContext().getRealPath("/") + "/report" + extension);
        InputStream is;
        try {
            is = new FileInputStream(file);
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
            }
            byte[] report = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            while (offset < report.length && (numRead = is.read(report, offset, report.length - offset)) >= 0) {
                offset += numRead;
            }
            if (offset < report.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
            is.close();

            final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + extension); // or whatever type you're sending back
            response.getOutputStream().write(report); // from the UploadDetails bean
            response.setContentLength(report.length);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(CreateAndDownloadReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        //delete file created on server
//        file.delete();
    }
    /**
     * A constants for buffer size used to read/write data
     */
    private static final int BUFFER_SIZE = 4096;

    /**
     * Compresses a collection of files to a destination zip file
     *
     * @param listFiles A collection of files and directories
     * @param destZipFile The path of the destination zip file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void compressFiles(List<File> listFiles, String destZipFile) throws FileNotFoundException, IOException {

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(destZipFile));

        for (File file : listFiles) {
            if (file.isDirectory()) {
                addFolderToZip(file, file.getName(), zos);
            } else {
                addFileToZip(file, zos);
            }
        }

        zos.flush();
        zos.close();
    }

    /**
     * Adds a directory to the current zip output stream
     *
     * @param folder the directory to be added
     * @param parentFolder the path of parent directory
     * @param zos the current zip output stream
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void addFolderToZip(File folder, String parentFolder,
            ZipOutputStream zos) throws FileNotFoundException, IOException {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                addFolderToZip(file, parentFolder + "/" + file.getName(), zos);
                continue;
            }

            zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));

            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));

            long bytesRead = 0;
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;

            while ((read = bis.read(bytesIn)) != -1) {
                zos.write(bytesIn, 0, read);
                bytesRead += read;
            }

            zos.closeEntry();

        }
    }

    /**
     * Adds a file to the current zip output stream
     *
     * @param file the file to be added
     * @param zos the current zip output stream
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void addFileToZip(File file, ZipOutputStream zos)
            throws FileNotFoundException, IOException {
        zos.putNextEntry(new ZipEntry(file.getName()));

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                file));

        long bytesRead = 0;
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;

        while ((read = bis.read(bytesIn)) != -1) {
            zos.write(bytesIn, 0, read);
            bytesRead += read;
        }

        zos.closeEntry();
    }

    public void downloadGeneratedZip(String fileName, String filePath) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        File file = new File(facesContext.getExternalContext().getRealPath("/") + "/" + filePath);
        InputStream is;
        try {
            is = new FileInputStream(file);
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
            }
            byte[] report = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            while (offset < report.length && (numRead = is.read(report, offset, report.length - offset)) >= 0) {
                offset += numRead;
            }
            if (offset < report.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
            is.close();

            final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".zip"); // or whatever type you're sending back
            response.getOutputStream().write(report); // from the UploadDetails bean
            response.setContentLength(report.length);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(CreateAndDownloadReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        //delete file created on server
//        file.delete();
    }
}
