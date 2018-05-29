package com.asignore.tos.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

    public static String toDate(Integer hour, Integer minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        ZonedDateTime zdt = date.toInstant().atZone(ZoneId.of("CET"));
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:SSSZ").format(zdt);
    }
}
