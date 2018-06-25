package com.se.tss.forum;

import java.sql.Timestamp;
import java.util.Calendar;

public class TimeManager {
    public static Timestamp getBeijingTime()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        Timestamp now = new Timestamp(calendar.getTimeInMillis());
        return now;
    }
}
