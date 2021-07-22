package com.ashish.datedemo.utility;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class DateTimeUtil {
    private static Date currentDate;
    private Integer year;
    private Integer month;


    public DateTimeUtil(Integer year, Integer month) {
        this.year = year;
        this.month = month;
    }

    public static void setCurrentDate(Date date) {
        currentDate = date;
    }

    public static Date getCurrentDate() {
        return currentDate;
    }

    public static Date nextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, 1);
        currentDate = cal.getTime();
        return currentDate;
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date getDateFromYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public static int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonthFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // month is formatted in the 0 to 11 format.
        return calendar.get(Calendar.MONTH) + 1;
    }

    // returns floor[difference] between months,
    public static int getMonthDifference(Date date1, Date date2) {
        int month1 = getMonthFromDate(date1);
        int month2 = getMonthFromDate(date2);
        return month1 - month2;
    }

    public static void displayCurrentTime() {
        System.out.printf("time,%d,%d%n",
                getMonthFromDate(DateTimeUtil.getCurrentDate()),
                getYearFromDate(DateTimeUtil.getCurrentDate()));

    }

    public boolean equalTo(DateTimeUtil dateTimeUtil) {
        return this.year.equals(dateTimeUtil.getYear()) && this.month.equals(dateTimeUtil.getMonth());
    }

    public static long getCurrentDateEpochTime() {
        return getCurrentDate().getTime();
    }

    public static long getDateFromYeaEpochTime(int year) {
        return getDateFromYear(year).getTime();
    }

    public static long getnextMonthEpochTime() {
        return nextMonth().getTime();
    }

    public String toString() {
        return this.year + " " + this.month;
    }


}


