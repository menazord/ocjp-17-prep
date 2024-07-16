package io.cristianmeneses.ocjp.lesson3.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class Timezones {

    public static void main(String[] args) {
        log.info("Lesson 3 - Time zone essentials.");
        Timezones t = new Timezones();
        t.getTimeZones();
        t.timezoneAccess();
        t.timeShifting();
        log.info("Lesson 3 - All done.");

    }

    public void getTimeZones() {
        ZoneId.getAvailableZoneIds().forEach(log::info);
    }

    public void timezoneAccess() {
        var zi = ZoneId.of("America/Los_Angeles");
        log.info("{}", zi);

        ZoneId.of("Europe/Berlin")
                .getRules()
                .getTransitions()
                .forEach(System.out::println);

        // When is the next transitions
        log.info("{}", zi.getRules().nextTransition(Instant.now()));

        // When was the last transition
        log.info("{}", zi.getRules().previousTransition(Instant.now()));
    }

    public void timeShifting() {
        var zi = ZoneId.of("America/Los_Angeles");

        // Next transition is on 2024-11-03T02:00
        var shiftTime = ZonedDateTime.parse("2024-11-02T00:00:00-07:00[America/Los_Angeles]");
        log.info("{}", shiftTime);
        log.info("{}", shiftTime.plusHours(24));
        log.info("{}", shiftTime.plusHours(48));
        log.info("{}", shiftTime.plusHours(72));
    }
}
