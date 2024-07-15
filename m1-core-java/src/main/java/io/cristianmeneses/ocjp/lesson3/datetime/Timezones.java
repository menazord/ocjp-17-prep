package io.cristianmeneses.ocjp.lesson3.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Timezones {

    public static void main(String[] args) {
        System.out.println("Time zone essentials.");
        getTimeZones();
        timezoneAccess();
        timeShifting();
        System.out.println("All done.");

    }

    private static void getTimeZones() {
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }

    private static void timezoneAccess() {
        var zi = ZoneId.of("America/Los_Angeles");
        System.out.println(zi);

        ZoneId.of("Europe/Berlin")
                .getRules()
                .getTransitions()
                .forEach(System.out::println);

        // When is the next transitions
        System.out.println(zi.getRules().nextTransition(Instant.now()));

        // When was the last transition
        System.out.println(zi.getRules().previousTransition(Instant.now()));
    }

    private static void timeShifting() {
        var zi = ZoneId.of("America/Los_Angeles");

        // Next transition is on 2024-11-03T02:00
        var shiftTime = ZonedDateTime.parse("2024-11-02T00:00:00-07:00[America/Los_Angeles]");
        System.out.println(shiftTime);
        System.out.println(shiftTime.plusHours(24));
        System.out.println(shiftTime.plusHours(48));
        System.out.println(shiftTime.plusHours(72));

    }
}
