package tech.guyi.web.quick.core.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String time){
        return Date.from(LocalDate.parse(time,formatter).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}
