package com.trigerz.vehicle.maintenance.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

import static java.lang.Math.abs;

@UtilityClass
public class DateUtils {
    public static LocalDate today(){
        return LocalDate.now();
    }

    public static Integer differenceInMonthWithToday(LocalDate date) throws UndefinedDateException {
        if (date == null){
            throw new UndefinedDateException("date does not exists");
        }
        return abs(today().getMonthValue() - date.getMonthValue());
    }
}
