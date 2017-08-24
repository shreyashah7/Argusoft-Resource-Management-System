/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.CalDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.UserTransformerBean;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Service bean for ganttChart
 *
 * @author ravi
 */
@ManagedBean(name = "ganttServiceBean")
@RequestScoped
public class GanttServiceBean {

    @ManagedProperty("#{calDataBean}")
    private CalDataBean calDataBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{taskServiceBean}")
    private TaskServiceBean taskServiceBean;

    @ManagedProperty("#{taskDataBean}")
    private TaskDataBean taskDataBean;

    @ManagedProperty("#{userTransformerBean}")
    private UserTransformerBean userTransformerBean;

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    private List<Date> listOfDates;
    private List<TaskDataBean> ganttDataList;

    public Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public List<TaskDataBean> getGanttDataList() {
        return ganttDataList;
    }

    public void setGanttDataList(List<TaskDataBean> ganttDataList) {
        this.ganttDataList = ganttDataList;
    }

    public List<Date> getListOfDates() {
        return listOfDates;
    }

    public void setListOfDates(List<Date> listOfDates) {
        this.listOfDates = listOfDates;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public UserTransformerBean getUserTransformerBean() {
        return userTransformerBean;
    }

    public void setUserTransformerBean(UserTransformerBean userTransformerBean) {
        this.userTransformerBean = userTransformerBean;
    }

    public TaskDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public void setTaskDataBean(TaskDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public TaskServiceBean getTaskServiceBean() {
        return taskServiceBean;
    }

    public void setTaskServiceBean(TaskServiceBean taskServiceBean) {
        this.taskServiceBean = taskServiceBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public CalDataBean getCalDataBean() {
        return calDataBean;
    }

    public void setCalDataBean(CalDataBean calDataBean) {
        this.calDataBean = calDataBean;
    }

    /**
     * @author ravi
     * @return no of days current month
     */
    public int getNoOfDaysCurrentMonth() {
        int actualDay = calDataBean.getCalendar().get(Calendar.DAY_OF_MONTH);
        int noOfDays = calDataBean.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
        calDataBean.getCalendar().set(Calendar.DAY_OF_MONTH, actualDay);
        return noOfDays;
    }

    /**
     * @author ravi sets the month value in calDataBean to previous month
     */
    public void setToPrevMonth() {
        int actualMonth = calDataBean.getCalendar().get(Calendar.MONTH);
        calDataBean.setMonth(actualMonth - 1);
    }

    /**
     * @author ravi sets the month value in calDataBean to next month
     */
    public void setToNextMonth() {
        int actualMonth = calDataBean.getCalendar().get(Calendar.MONTH);
        calDataBean.setMonth(actualMonth + 1);
    }

    /**
     * @author ravi
     * @return next month Jan-Dec(0-11)
     */
    public int nextMonth() {
        int currentMonth = calDataBean.getCalendar().get(Calendar.MONTH);
        if (currentMonth != 11) {
            currentMonth = currentMonth + 1;

        } else {
            currentMonth = 0;
            calDataBean.setYear(calDataBean.getYear() + 1);
        }
        return currentMonth;
    }

    /**
     * @author ravi
     * @return previous month Jan-Dec(0-11)
     */
    public int prevMonth() {
        int currentMonth = calDataBean.getCalendar().get(Calendar.MONTH);
        if (currentMonth != 0) {
            currentMonth = currentMonth - 1;
        } else {
            currentMonth = 11;
            calDataBean.setYear(calDataBean.getYear() - 1);
        }
        return currentMonth;
    }

    /**
     * @author ravi gets list of all the users and sets it inside ListOfUsers in
     * systemResultViewUtil
     */
    public void populateListOfUsers() {
        List<UserDataBean> users = new ArrayList<>();
        try {
            users = userTransformerBean.retrieveUsers();
        } catch (UMUserManagementException | GenericDatabaseException ex) {
            Logger.getLogger(GanttServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        systemResultViewUtil.setListOfUsers(users);
    }

    /**
     * @author ravi generates the Gantt Chart list and sets it in ganttDataList
     */
    public void populateGanttChart() {
        int currentMonth = calDataBean.getMonth();
        if (currentMonth != 0) {
            systemResultViewUtil.setPrevMonthName("<<" + months[currentMonth - 1]);
        } else {
            systemResultViewUtil.setPrevMonthName("<<" + months[11]);
        }
        if (currentMonth != 11) {
            systemResultViewUtil.setNextMonthName(months[currentMonth + 1] + ">>");
        } else {
            systemResultViewUtil.setNextMonthName(months[0] + ">>");
        }

        int currMonth = calDataBean.getMonth();
        int currYear = calDataBean.getYear();
        int noOfDaysCurrentMonth = getNoOfDaysCurrentMonth();

        if (systemResultViewUtil.getUserIdForCalendar() == 0) {
            systemResultViewUtil.setUserIdForCalendar(loginDataBean.getId());
        }

        Calendar startTime = Calendar.getInstance();
        startTime.set(currYear, currMonth, 1, 0, 0, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(currYear, currMonth, noOfDaysCurrentMonth, 23, 59, 59);

        List<TaskDataBean> tasksForMonth = taskServiceBean.retrieveTasksForIntervalByIdForGantt(systemResultViewUtil.getUserIdForCalendar(), startTime, endTime);

        List<TaskDataBean> newListOfTask = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        for (TaskDataBean taskData : tasksForMonth) {
            if (taskData.getActualEndDate() == null && taskData.getStartDate() != null && taskData.getEndDate() != null) {
                if (taskData.getStartDate().getTime() > calendar.getTime().getTime()) {

                    if (taskData.getEndDate().getTime() < startTime.getTime().getTime()) {

                    } else {
//                        System.out.println("if 1 task id" + taskData.getTaskId());
                        taskData.setActualEndDate(calendar.getTime());
                        taskData.setShow("FALSE");
                        newListOfTask.add(taskData);
                    }
                } else {
                    if (calendar.getTimeInMillis() < startTime.getTimeInMillis()) {

                    } else {
//                        System.out.println("if 2 task id" + taskData.getTaskId());
                        taskData.setActualEndDate(calendar.getTime());
                        taskData.setShow("FALSE");
                        newListOfTask.add(taskData);
                    }
                }
            } else {
//                System.out.println("if 3 task id" + taskData.getTaskId());
                if (taskData.getActualEndDate() == null) {
                    taskData.setShow("FALSE");
                } else {
                    taskData.setShow("TRUE");
                }
                newListOfTask.add(taskData);
            }
        }

        List<TaskDataBean> taskList = new ArrayList<>();
        for (TaskDataBean taskData : newListOfTask) {
            if (taskData.getActualEndDate() == null) {
//                System.out.println("if 4 task id" + taskData.getTaskId());
                taskData.setActualEndDate(getCurrentDate());
                taskData.setShow("FALSE");
            } else {

            }
            taskList.add(taskData);

        }

        Collections.sort(taskList);

        int start = calDataBean.getYear() - 10;
        int end = calDataBean.getYear() + 10;

        List listOfyears = new ArrayList();
        for (int year = start; year < end; year++) {
            listOfyears.add(year);
        }

        List<Date> listOfDates = new ArrayList<>();

        for (int date = 1; date <= noOfDaysCurrentMonth; date++) {
            Calendar currdate = Calendar.getInstance();
            currdate.set(currYear, currMonth, date, 0, 0, 0);
            currdate.set(Calendar.MILLISECOND, 0);
            listOfDates.add(currdate.getTime());
        }
        setListOfDates(listOfDates);
        systemResultViewUtil.setListOfyears(listOfyears);
        setGanttDataList(taskList);
    }

}
