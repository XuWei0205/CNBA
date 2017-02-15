package com.hanyu.cnba.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Dell on 2016/11/27.
 */
public class Date {
    private SimpleDateFormat dateFormat;
    private Calendar now;
    public String getDate(){
        String date;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        now = Calendar.getInstance();
        date = dateFormat.format(now.getTime());
        return date;
    }
    public String getDate(int i){
        String date;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        now = Calendar.getInstance();
        now.add(Calendar.DATE,i);
        date = dateFormat.format(now.getTime());
        return date;

    }
}
