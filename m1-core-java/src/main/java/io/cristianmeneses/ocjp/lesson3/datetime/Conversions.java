package io.cristianmeneses.ocjp.lesson3.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Conversions {

    public static void main(String[] args) {

        Conversions c = new Conversions();
        c.dateAndTime();
        c.instants();
    }

    public void dateAndTime() {

        var ld = LocalDate.of(2024, 1, 1);
        var lt = LocalTime.of(12, 55);
        var ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt);

        var ldt2 = LocalDate.of(2000, 1, 1).adjustInto(ldt);
        System.out.println("[" + ldt2.getClass().getName() + "] " + ldt2);

        var ldt3 = LocalDateTime.from(LocalDate.of(1900, 1, 1).adjustInto(ldt));
        System.out.println("[" + ldt3.getClass().getName() + "] " + ldt3);

        var zdt = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));
        System.out.println("[" + zdt.getClass().getName() + "] " + zdt);

        var zdt2 = zdt.withZoneSameInstant(ZoneId.of("America/Santiago"));
        System.out.println("[" + zdt2.getClass().getName() + "] " + zdt2);

        System.out.println("zdt equals zdt2 ? " + zdt.equals(zdt2));
        System.out.println("zdt Instant equals zdt2 Instant ? " + zdt.toInstant().equals(zdt2.toInstant()));

        Instant instant = zdt.toInstant();
        System.out.println("[" + instant.getClass().getName() + "] " + instant);
    }

    public void instants() {

        Period oneYear = Period.ofYears(1);
        Period oneMonth = Period.ofMonths(1);

        ZonedDateTime febOne2020 =
                ZonedDateTime.of(2020, 2, 1, 12, 15, 30, 0, ZoneId.of("GMT"));
        ZonedDateTime febOne2021 = febOne2020.plus(oneYear);
        ZonedDateTime marOne2020 = febOne2020.plus(oneMonth);
        ZonedDateTime marOne2021 = febOne2021.plus(oneMonth);

        Instant febOne2020Inst = febOne2020.toInstant();
        Instant marOne2020Inst = marOne2020.toInstant();
        Instant marOne2021Inst = marOne2021.toInstant();

        System.out.println(febOne2020Inst.until(marOne2020Inst, ChronoUnit.DAYS));
        System.out.println(marOne2020Inst.until(marOne2021Inst, ChronoUnit.DAYS));
    }

}
