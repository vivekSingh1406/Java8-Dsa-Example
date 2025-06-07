package org.example.java8.date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateAndTimeBasic {
    public static void main(String[] args) {

        // get the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);


        // get the current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);


        // get teh current date and time together
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentDateTime);


        // get formatter data
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);



        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("ZonedDateTime: " + zonedDateTime);


        // diff between two date
        LocalDate startDate = LocalDate.of(2000, 6, 14);
        LocalDate endDate = LocalDate.now();

        Period period = Period.between(startDate, endDate);
        System.out.println("Difference: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");

    }

}
