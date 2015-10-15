package guru.springframework.blog.currenttime;

import java.time.*;
import java.time.format.DateTimeFormatter;
public class CurrentTimeJava8 {
   public static void getCurrentTime(){
        System.out.println("-----Current time of your time zone-----");
        LocalTime time = LocalTime.now();
        System.out.println("Current time of the day: " + time);
    }
    public static void getCurrentTimeWithTimeZone(){
        System.out.println("-----Current time of a different time zone using LocalTime-----");
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        LocalTime localTime=LocalTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime=localTime.format(formatter);
        System.out.println("Current time of the day in Los Angeles: " + formattedTime);

    }
    public static void getCurrentTimeWithOffset(){
        System.out.println("-----Current time of different offset-----");
        ZoneOffset zoneOffset = ZoneOffset.of("-08:00");
        ZoneId zoneId=ZoneId.ofOffset("UTC", zoneOffset);
        LocalTime offsetTime = LocalTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime=offsetTime.format(formatter);
        System.out.println("Current time of the day with offset -08:00: " + formattedTime);

    }
}

