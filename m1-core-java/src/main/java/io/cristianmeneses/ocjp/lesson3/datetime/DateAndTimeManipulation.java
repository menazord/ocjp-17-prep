package io.cristianmeneses.ocjp.lesson3.datetime;

import java.time.*;
import java.time.temporal.ChronoField;

public class DateAndTimeManipulation {

    public static void main(String[] args) {

        System.out.println("Date-time API foundations.");
        pointsInTime();
        immutability();
        temporalAccessors();
        extractions();
        System.out.println("All done.");
    }

    private static void pointsInTime() {

        //Instant and ZonedDateTime represent ABSOLUTE points in time.
        Instant i1 = Instant.now();
        System.out.println(i1);

        ZonedDateTime zdt = ZonedDateTime.ofInstant(i1, ZoneId.of("America/Denver"));
        System.out.println(zdt);

        // LocalDate, LocalTime and LocalDateTime represent RELATIVE points in time.
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.toLocalDate());
        System.out.println(ldt.toLocalTime());

        // Duration and Period represent ELAPSED time. Duration is ABSOLUTE while Period is context dependant.
        Duration d = Duration.ofMinutes(340);
        System.out.println(d);

        Period p = Period.of(1, 14, 540);
        System.out.println(p);

        // Normalization takes care of adding an extra year for each 12 months, however it will not normalize the
        // days, since there is no ABSOLUTE point in time to make up for leap years, days in months and such.
        System.out.println(p.normalized());
    }

    private static void immutability() {

        LocalDate ld = LocalDate.of(2065, 4, 13);
        System.out.println(ld);

        // Access date components - get*
        System.out.println(ld.getMonth());

        // Alter the value - plus*
        LocalDate ld2 = ld.plusDays(10);
        System.out.println(ld2);

        // Access low level fields - with*
        System.out.println(ld.with(ChronoField.MONTH_OF_YEAR, 7));

        // Parse from text - from*
        var ld3 = LocalDate.parse("2000-07-14");
        System.out.println(ld3);
    }

    private static void temporalAccessors() {

        // Initialize an object with the contents of another object, providing that the source object
        // contains all the information to initialize the target object. Runtime failures may occur.
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = LocalDate.from(ldt);
        System.out.println(ld);
    }

    private static void extractions() {

        // LocalDate has no time information, and cannot be used to create a LocalTime, but compiler allows
        // this since both classes extend TemporalAccessor. These errors occur at runtime.
        LocalDate ld = LocalDate.now();
        try {
            LocalTime lt = LocalTime.from(ld);
            System.out.println(lt);
        } catch (Exception e) {
            System.out.println("Got error [" + e.getMessage() + "]");
        }

        System.out.println(ld.getYear());
        System.out.println(ld.get(ChronoField.YEAR));

        // Again, extracting a time component from a date-only component will fail.
        try {
            System.out.println(ld.get(ChronoField.HOUR_OF_DAY));
        } catch (Exception e) {
            System.out.println("Got error [" + e.getMessage() + "]");
        }

        // We can check whether something is supported
        System.out.println("LocalDate supports months ? " + ld.isSupported(ChronoField.MONTH_OF_YEAR));
        System.out.println("LocalDate supports hours ? " + ld.isSupported(ChronoField.HOUR_OF_DAY));

        // Create a LocalDateTime from a LocalDate by providing the time component
        var ldt = ld.atTime(11, 22);
        System.out.println("[" + ldt.getClass().getName() + "] - " + ldt);

        // Change the date portion but keeping the time
        var ld2 = LocalDate.of(2100, 1, 1);
        var res = ld2.adjustInto(ldt);
        System.out.println("[" + res.getClass().getName() + "] - " + res);

        // Tests
        System.out.println("[" + ld2 + "] is leap year ? " + ld2.isLeapYear());

        // Shifting time by periods
        Period thirty = Period.ofDays(30);
        LocalDate feb14 = LocalDate.of(2024, 2, 14);
        System.out.println(feb14);
        System.out.println(feb14.plus(thirty));


        Period oneMonth = Period.ofMonths(1);
        System.out.println(feb14.plus(oneMonth));
    }

}
