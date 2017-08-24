/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.CalDataBean;
import com.argusoft.armms.web.databean.DayDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.UserTransformerBean;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * service bean for Calender
 *
 * @author ravi
 */
@ManagedBean(name = "calServiceBean")
@RequestScoped
public class CalServiceBean {

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

    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

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

    public Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * @author ravi
     * @return no of weeks in current month
     */
    public int getNoOfWeeks() {
        float rows = (float) (getFirstDayOfMonth() + getNoOfDaysCurrentMonth()) / 7;
        return (int) Math.ceil(rows);
    }

    /**
     * @author ravi
     * @return the day on 1st of current month
     */
    public int getFirstDayOfMonth() {
        int day = calDataBean.getCalendar().get(Calendar.DAY_OF_MONTH);
        calDataBean.getCalendar().set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = calDataBean.getCalendar().get(Calendar.DAY_OF_WEEK);
        calDataBean.getCalendar().set(Calendar.DAY_OF_MONTH, day);
        return firstDay;
    }

    /**
     * @author ravi
     * @return the day on last day of current month
     */
    public int getLastDayOfMonth() {
        int actualDay = calDataBean.getCalendar().get(Calendar.DAY_OF_MONTH);
        calDataBean.getCalendar().set(Calendar.DAY_OF_MONTH, getNoOfDaysCurrentMonth());
        int lastDay = calDataBean.getCalendar().get(Calendar.DAY_OF_WEEK);
        calDataBean.getCalendar().set(Calendar.DAY_OF_MONTH, actualDay);
        return lastDay;
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
     * @author ravi
     * @return no of days last month
     */
    public int getNoOfDaysLastMonth() {
        int actualMonth = calDataBean.getCalendar().get(Calendar.MONTH);
        calDataBean.getCalendar().set(Calendar.MONTH, actualMonth - 1);
        int daysInLastMonth = calDataBean.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
        calDataBean.getCalendar().set(Calendar.MONTH, actualMonth);
        return daysInLastMonth;
    }

    /**
     * sets values in the taskDataBean
     *
     * @author ravi
     * @param task object of TaskDataBean
     */
    public void setValuesForPopUp(TaskDataBean task) {
        taskDataBean.setTaskId(task.getTaskId());
        taskDataBean.setTaskName(task.getTaskName());
        taskDataBean.setTaskDescription(task.getTaskDescription());
        taskDataBean.setStartDate(task.getStartDate());
        taskDataBean.setEndDate(task.getEndDate());
        taskDataBean.setProjectId(task.getProjectId());
        taskDataBean.setProjectAlias(task.getProjectAlias());
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
    public void populateListOfUsers() throws GenericDatabaseException {

        List<UserDataBean> users = new ArrayList<>();
        try {
            users = userTransformerBean.retrieveUsers();
        } catch (UMUserManagementException | GenericDatabaseException ex) {
            Logger.getLogger(CalServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        systemResultViewUtil.setListOfUsers(users);
    }

    /**
     * @author ravi populate the Calendar for particular month
     */
    public void populateCalendar() {

        int currentMonth = calDataBean.getCalendar().get(Calendar.MONTH);
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

        int firstDayOfMonth = getFirstDayOfMonth();
        int noOfDaysCurrentMonth = getNoOfDaysCurrentMonth();
        int noOfDaysLastMonth = getNoOfDaysLastMonth();
        int lastDayOfMonth = getLastDayOfMonth();

        int currentYear = calDataBean.getYear();
        int prevMonth = calDataBean.getMonth() - 1;

        //for filling the last months days
        List list = new ArrayList();
        DayDataBean dayData;
        if (firstDayOfMonth != 1) {
            int date = noOfDaysLastMonth - firstDayOfMonth + 2;
            for (int cnt = 1; cnt < firstDayOfMonth; cnt++) {
                dayData = new DayDataBean();
                Calendar calendar = Calendar.getInstance();
                calendar.set(currentYear, prevMonth, date, 0, 0, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                Date currdate = calendar.getTime();
                dayData.setDate(currdate);
                dayData.setShow(Boolean.FALSE);
                dayData.setTask(null);
                list.add(dayData);
                date++;
            }
        }

        int currMonth = calDataBean.getMonth();
        int currYear = calDataBean.getYear();

        if (systemResultViewUtil.getUserIdForCalendar() == 0) {

            systemResultViewUtil.setUserIdForCalendar(loginDataBean.getId());
        }

        //for filling the last months days and details
        Calendar startTime = Calendar.getInstance();
        startTime.set(currYear, currMonth, 1, 0, 0, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(currYear, currMonth, noOfDaysCurrentMonth, 23, 59, 59);

        List<TaskDataBean> tasksForIntervalById = taskServiceBean.retrieveTasksForIntervalById(systemResultViewUtil.getUserIdForCalendar(), startTime, endTime);
        Map<Integer, List<TaskDataBean>> monthMap = new TreeMap();

        for (TaskDataBean taskData : tasksForIntervalById) {

            String taskId = taskData.getTaskId();
            Date startDate = taskData.getStartDate();
            Date endDate = taskData.getEndDate();

            Integer start;
            Integer end;

            if (startDate.after(startTime.getTime())) {
                start = startDate.getDate();
                if (endDate.after(endTime.getTime())) {
                    end = endTime.get(Calendar.DAY_OF_MONTH);
                } else {
                    end = taskData.getEndDate().getDate();
                }
            } else {
                start = 1;
                if (endDate.before(endTime.getTime())) {
                    end = taskData.getEndDate().getDate();
                } else {
                    end = endTime.get(Calendar.DAY_OF_MONTH);
                }
            }
            for (int i = start; i <= end; i++) {
                if (monthMap.containsKey(i)) {
                    List<TaskDataBean> get = monthMap.get(i);
                    get.add(taskData);
                    monthMap.put(i, get);
                } else {
                    List<TaskDataBean> newList = new ArrayList();
                    newList.add(taskData);
                    monthMap.put(i, newList);
                }

            }

        }

        for (int date = 1; date <= noOfDaysCurrentMonth; date++) {
            dayData = new DayDataBean();
            Calendar calendar = Calendar.getInstance();
            calendar.set(currentYear, currMonth, date, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date currdate = calendar.getTime();
            dayData.setDate(currdate);
            dayData.setShow(Boolean.TRUE);
            dayData.setTask("task");
            dayData.setTaskDataBeans(monthMap.get(date));
            list.add(dayData);
        }

        //for filling the next months days
        int nextMonth = calDataBean.getMonth() + 1;
        if (lastDayOfMonth != 7) {
            int fill = 7 - lastDayOfMonth;
            for (int date = 1; date <= fill; date++) {
                dayData = new DayDataBean();
                Calendar calendar = Calendar.getInstance();
                calendar.set(currentYear, nextMonth, date, 0, 0, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                Date currdate = calendar.getTime();
                dayData.setDate(currdate);
                dayData.setShow(Boolean.FALSE);
                dayData.setTask(null);
                list.add(dayData);
            }
        }
        for (Iterator it = list.iterator(); it.hasNext();) {
            DayDataBean object = (DayDataBean) it.next();
        }

        // for generating a list weekwise
        List<List<DayDataBean>> month = new ArrayList<>();
        List<DayDataBean> week = new ArrayList<DayDataBean>();
        int cnt = 0;
        for (Iterator days = list.iterator(); days.hasNext();) {
            if (cnt == 7) {
                month.add(week);
                week = new ArrayList<DayDataBean>();
                cnt = 0;
                week.add((DayDataBean) days.next());
            } else {
                week.add((DayDataBean) days.next());
            }
            cnt++;
        }
        month.add(week);

        //generating list of years last 10 years and next 10 years
        int start = calDataBean.getYear() - 10;
        int end = calDataBean.getYear() + 10;

        List listOfyears = new ArrayList();
        for (int year = start; year < end; year++) {
            listOfyears.add(year);
        }

        systemResultViewUtil.setListOfyears(listOfyears);
        calDataBean.setNoOfWeeks(getNoOfWeeks());
        systemResultViewUtil.setCalendarDataList(month);
    }
}
