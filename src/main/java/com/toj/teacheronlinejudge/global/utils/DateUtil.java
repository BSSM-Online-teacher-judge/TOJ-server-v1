package com.toj.teacheronlinejudge.global.utils;

import java.time.LocalDateTime;

public class DateUtil {

    public static LocalDateTime monthOfToday() {
        LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.of(
                now.getYear(),
                now.getMonth(),
                1, 0,0,0
        );
    }
}
