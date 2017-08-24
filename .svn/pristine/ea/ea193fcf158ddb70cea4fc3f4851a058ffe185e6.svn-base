/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.reports;

import com.argusoft.armms.web.reports.databean.EmployeePerformanceDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * Employee Performance report evaluating tasks performed on each project
 *
 * @author shreya
 */
@ManagedBean(name = "employeePerformanceReport")
@RequestScoped
public class EmployeePerformanceReport {

    @ManagedProperty(value = "#{createAndDownloadReport}")
    private CreateAndDownloadReport createAndDownloadReport;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{employeePerformanceDataBean}")
    private EmployeePerformanceDataBean employeePerformanceDataBean;

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public CreateAndDownloadReport getCreateAndDownloadReport() {
        return createAndDownloadReport;
    }

    public void setCreateAndDownloadReport(CreateAndDownloadReport createAndDownloadReport) {
        this.createAndDownloadReport = createAndDownloadReport;
    }

    public EmployeePerformanceDataBean getEmployeePerformanceDataBean() {
        return employeePerformanceDataBean;
    }

    public void setEmployeePerformanceDataBean(EmployeePerformanceDataBean employeePerformanceDataBean) {
        this.employeePerformanceDataBean = employeePerformanceDataBean;
    }

    /**
     * createReport() uses TextColumnBuilder and creates report using employeePerformance ReportDataBean
     * It just takes the list into datasource and generates report
     * @author shreya
     */

    public void createReport() throws FileNotFoundException, IOException, DRException {
        System.out.println("inside create report------->>>>");
        //Title to be displayed on the report
        String title = systemResultSessionUtil.getUserName() + "'s Performance Report";

        //File Name for the report
        String fileName = systemResultSessionUtil.getUserName() + "'s Performance Report";

        //Extension of the file
        String extension = systemResultViewUtil.getExtension();

        //Columns For Report
        TextColumnBuilder<String> column1 = col.column("Task Name", "taskName", type.stringType()).setFixedWidth(75).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        TextColumnBuilder<String> column2 = col.column("Project Name", "projectName", type.stringType()).setFixedWidth(75).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        TextColumnBuilder<Date> column3 = col.column("Task StartDate", "taskStartDate", type.dateType()).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        TextColumnBuilder<String> column4 = col.column("Task EndDate", "taskActualEndDates", type.stringType()).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        TextColumnBuilder<String> column5 = col.column("Task Status", "taskStatus", type.stringType()).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        TextColumnBuilder<String> column6 = col.column("Performance", "performance", type.stringType()).setHorizontalAlignment(HorizontalAlignment.RIGHT);

        //method that will create and download the report
        createAndDownloadReport.createReport(fileName, title, createDataSource(), extension, column1, column2, column3, column4, column5, column6);

    }
    
    /**
     * creates Datasource using list of values.
     * Returns datasource with assigned values to it.
     * @author shreya
     */

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("taskName", "projectName", "taskStartDate", "taskActualEndDates", "taskStatus", "performance");
        if (systemResultViewUtil.getEmployeePerformanceList() != null && !systemResultViewUtil.getEmployeePerformanceList().isEmpty()) {
            for (EmployeePerformanceDataBean employeePerformanceDataBeanVar : systemResultViewUtil.getEmployeePerformanceList()) {
                String taskName = employeePerformanceDataBeanVar.getTaskName();
                String projectName = employeePerformanceDataBeanVar.getProjectName();
                Date taskStartDate = employeePerformanceDataBeanVar.getTaskStartDate();
                String taskActualEndDates = null;
                if (employeePerformanceDataBeanVar.getTaskActualEndDate() == null) {
                    taskActualEndDates = SystemConstantUtil.NOT_AVAILABLE;
                } else {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    taskActualEndDates = df.format(employeePerformanceDataBeanVar.getTaskActualEndDate());
                }
                String taskStatus = employeePerformanceDataBeanVar.getTaskStatus();
                String performance = employeePerformanceDataBeanVar.getPerformance();
                dataSource.add(taskName, projectName, taskStartDate, taskActualEndDates, taskStatus, performance);
            }
        }
        return dataSource;
    }
}
