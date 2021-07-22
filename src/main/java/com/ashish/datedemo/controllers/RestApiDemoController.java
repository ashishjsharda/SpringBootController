package com.ashish.datedemo.controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.Date;

@Controller
public class RestApiDemoController {


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @Value("10-01-2020")
    private Date defaultDate;

    @RequestMapping(value = "/getYearFromDate", method = RequestMethod.GET)
    @ResponseBody

    public static int getYearFromDate(@RequestParam(value="date") @DateTimeFormat(pattern="MMddyyyy") Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    @RequestMapping(value = "/getMonthFromDate", method = RequestMethod.GET)
    @ResponseBody
    public static int getMonthFromDate(@RequestParam(value="date") @DateTimeFormat(pattern="MMddyyyy") Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    @RequestMapping(value = "/getLastDayOfMonth", method = RequestMethod.GET)
    @ResponseBody
    public static Date getLastDayOfMonth(@RequestParam(value="date") @DateTimeFormat(pattern="MMddyyyy") Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    @RequestMapping(value = "/getDateFromYear", method = RequestMethod.GET)
    @ResponseBody
    public static Date getDateFromYear(@RequestParam(value="year") int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    @RequestMapping(value = "/getMonthDifference", method = RequestMethod.GET)
    @ResponseBody
    public static int getMonthDifference(@RequestParam(value="date1") @DateTimeFormat(pattern="MMddyyyy")Date date1, @RequestParam(value="date2") @DateTimeFormat(pattern="MMddyyyy")Date date2) {
        int month1 = getMonthFromDate(date1);
        int month2 = getMonthFromDate(date2);
        return month1 - month2;
    }

    @RequestMapping(value = "/getNextMonthFromDate", method = RequestMethod.GET)
    @ResponseBody
    public static int getNextMonthFromDate(@RequestParam(value="date") @DateTimeFormat(pattern="MMddyyyy") Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month=calendar.get(Calendar.MONTH);
        if(month==11)
        {
            return 1;
        }
        return calendar.get(Calendar.MONTH) + 2;
    }

}
