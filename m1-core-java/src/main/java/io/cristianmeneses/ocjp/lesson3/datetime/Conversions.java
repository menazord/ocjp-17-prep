package io.cristianmeneses.ocjp.lesson3.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoUnit;

@Slf4j
public class Conversions {

    public static void main(String[] args) {
        log.info("Lesson 3 - Date-time API conversions.");
        Conversions c = new Conversions();
        c.dateAndTime();
        c.instants();
        log.info("Lesson 3 - All done.");
    }

    public void dateAndTime() {

        var ld = LocalDate.of(2024, 1, 1);
        var lt = LocalTime.of(12, 55);
        var ldt = LocalDateTime.of(ld, lt);
        log.info("{}", ldt);

        var ldt2 = LocalDate.of(2000, 1, 1).adjustInto(ldt);
        log.info("[" + ldt2.getClass().getName() + "] " + ldt2);

        var ldt3 = LocalDateTime.from(LocalDate.of(1900, 1, 1).adjustInto(ldt));
        log.info("[" + ldt3.getClass().getName() + "] " + ldt3);

        var zdt = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));
        log.info("[" + zdt.getClass().getName() + "] " + zdt);

        var zdt2 = zdt.withZoneSameInstant(ZoneId.of("America/Santiago"));
        log.info("[" + zdt2.getClass().getName() + "] " + zdt2);

        log.info("zdt equals zdt2 ? " + zdt.equals(zdt2));
        log.info("zdt Instant equals zdt2 Instant ? " + zdt.toInstant().equals(zdt2.toInstant()));

        Instant instant = zdt.toInstant();
        log.info("[" + instant.getClass().getName() + "] " + instant);
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

        log.info("{}", febOne2020Inst.until(marOne2020Inst, ChronoUnit.DAYS));
        log.info("{}", marOne2020Inst.until(marOne2021Inst, ChronoUnit.DAYS));
    }

}
