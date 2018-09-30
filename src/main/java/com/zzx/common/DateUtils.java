package com.zzx.common;

import java.time.LocalDateTime;

public class DateUtils {

    private  static final LocalDateTime nowDateTime = LocalDateTime.now();

    public static Integer acquireYear() {
        return nowDateTime.getYear();
    }

    public static Integer acquireMonth() {
        return nowDateTime.getMonthValue();
    }

    public static Integer acquireDay() {
        return nowDateTime.getDayOfMonth();
    }
}
