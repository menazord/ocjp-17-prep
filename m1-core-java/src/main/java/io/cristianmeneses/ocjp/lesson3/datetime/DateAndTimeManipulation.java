package io.cristianmeneses.ocjp.lesson3.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoField;

@Slf4j
public class DateAndTimeManipulation {

    public static void main(String[] args) {

        log.info("Lesson 3 - Date-time API foundations.");
        DateAndTimeManipulation d = new DateAndTimeManipulation();
        d.pointsInTime();
        d.immutability();
        d.temporalAccessors();
        d.extractions();
        log.info("Lesson 3 - All done.");
    }

    public void pointsInTime() {

        //Instant and ZonedDateTime represent ABSOLUTE points in time.
        Instant i1 = Instant.now();
        log.info("{}", i1);

        ZonedDateTime zdt = ZonedDateTime.ofInstant(i1, ZoneId.of("America/Denver"));
        log.info("{}", zdt);

        // LocalDate, LocalTime and LocalDateTime represent RELATIVE points in time.
        LocalDateTime ldt = LocalDateTime.now();
        log.info("{}", ldt);
        log.info("{}", ldt.toLocalDate());
        log.info("{}", ldt.toLocalTime());

        // Duration and Period represent ELAPSED time. Duration is ABSOLUTE while Period is context dependant.
        Duration d = Duration.ofMinutes(340);
        log.info("{}", d);

        Period p = Period.of(1, 14, 540);
        log.info("{}", p);

        // Normalization takes care of adding an extra year for each 12 months, however it will not normalize the
        // days, since there is no ABSOLUTE point in time to make up for leap years, days in months and such.
        log.info("{}", p.normalized());
    }

    public void immutability() {

        LocalDate ld = LocalDate.of(2065, 4, 13);
        log.info("{}", ld);

        // Access date components - get*
        log.info("{}", ld.getMonth());

        // Alter the value - plus*
        LocalDate ld2 = ld.plusDays(10);
        log.info("{}", ld2);

        // Access low level fields - with*
        log.info("{}", ld.with(ChronoField.MONTH_OF_YEAR, 7));

        // Parse from text - from*
        var ld3 = LocalDate.parse("2000-07-14");
        log.info("{}", ld3);
    }

    public void temporalAccessors() {

        // Initialize an object with the contents of another object, providing that the source object
        // contains all the information to initialize the target object. Runtime failures may occur.
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = LocalDate.from(ldt);
        log.info("{}", ld);
    }

    public void extractions() {

        // LocalDate has no time information, and cannot be used to create a LocalTime, but compiler allows
        // this since both classes extend TemporalAccessor. These errors occur at runtime.
        LocalDate ld = LocalDate.now();
        try {
            LocalTime lt = LocalTime.from(ld);
            log.info("{}", lt);
        } catch (Exception e) {
            log.error("Got error [{}]", e.getMessage());
        }

        log.info("{}", ld.getYear());
        log.info("{}", ld.get(ChronoField.YEAR));

        // Again, extracting a time component from a date-only component will fail.
        try {
            log.info("{}", ld.get(ChronoField.HOUR_OF_DAY));
        } catch (Exception e) {
            log.error("Got error [{}}]", e.getMessage());
        }

        // We can check whether something is supported
        log.info("LocalDate supports months ? " + ld.isSupported(ChronoField.MONTH_OF_YEAR));
        log.info("LocalDate supports hours ? " + ld.isSupported(ChronoField.HOUR_OF_DAY));

        // Create a LocalDateTime from a LocalDate by providing the time component
        var ldt = ld.atTime(11, 22);
        log.info("[" + ldt.getClass().getName() + "] - " + ldt);

        // Change the date portion but keeping the time
        var ld2 = LocalDate.of(2100, 1, 1);
        var res = ld2.adjustInto(ldt);
        log.info("[" + res.getClass().getName() + "] - " + res);

        // Tests
        log.info("[" + ld2 + "] is leap year ? " + ld2.isLeapYear());

        // Shifting time by periods
        Period thirty = Period.ofDays(30);
        LocalDate feb14 = LocalDate.of(2024, 2, 14);
        log.info("{}", feb14);
        log.info("{}", feb14.plus(thirty));


        Period oneMonth = Period.ofMonths(1);
        log.info("{}", feb14.plus(oneMonth));
    }

}
