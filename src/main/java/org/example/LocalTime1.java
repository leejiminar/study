package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalTime1 {
    public static void main(String[] args) {
        LocalDate lastChristmas = LocalDate.of(2022, 12, 25);
        LocalDate today = LocalDate.now();

        Period period = Period.between(lastChristmas, today);
        System.out.println("today: " + today);

        long datePassed = ChronoUnit.DAYS.between(lastChristmas, today);

        System.out.println("today: " + today);
        System.out.println(datePassed + " day passed from last christmas.");

//        -------------------

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalTime startTime = LocalTime.of(14, 0, 0);
        LocalTime endTime = LocalTime.of(17, 13, 47);

        Duration duration = Duration.between(startTime, endTime);

        System.out.println(duration);
        System.out.println(ChronoUnit.SECONDS.between(startTime, endTime));
    }
}
