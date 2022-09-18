package com.toj.teacheronlinejudge.global.utils;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateUtil {

    public static LocalDateTime monthOfStart() {
        LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.of(
                now.getYear(),
                now.getMonth(),
                1, 0,0,0
        );
    }

    public static LocalDateTime monthOfEnd() {
        LocalDateTime now = LocalDateTime.now();
        Calendar calendar = Calendar.getInstance();
        calendar.set(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
        int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return LocalDateTime.of(
                now.getYear(),
                now.getMonth(),
                lastDayOfMonth, 23,59, 59
        );
    }
}
