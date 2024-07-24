package io.cristianmeneses.ocjp.lesson5.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryCatchFinally {

    private static final String GOOD_STRING = "1.2.3.4";
    private static final String BAD_STRING = "1.2.3.z";

    public static void main(String[] args) {
        log.info("Lesson 5 - Flow control with try-catch-finally.");
        TryCatchFinally t = new TryCatchFinally();
        t.simpleTryCatchFinally(GOOD_STRING);
        t.simpleTryCatchFinally(BAD_STRING);

        t.nestedTryCatchFinally(GOOD_STRING);
        t.nestedTryCatchFinally(BAD_STRING);

        log.info("Lesson 5 - All done");
    }

    public void simpleTryCatchFinally(final String s) {
        int sum = 0;
        log.info("--- Entering try-catch-finally ---");
        try {
            String[] parts = s.split("\\.");
            for (String p: parts) {
                sum += Integer.parseInt(p);
            }
            log.info("Completed sum without errors");
        } catch (Exception e) {
            log.error("Completed sum exceptionally.");
        } finally {
            log.info("Finally block at the very last!");
        }

        log.info("After try-catch-finally with sum {}", sum);
    }

    public void nestedTryCatchFinally(final String s) {
        int sum = 0;
        log.info("--- Entering outer try-catch-finally ---");
        try {
            String[] parts = s.split("\\.");
            for (String p: parts) {
                log.info("Entering inner try-finally");
                try {
                    sum += Integer.parseInt(p);
                } finally {
                    log.info("Executing inner finally block");
                }
            }
            log.info("Resumed outer try without errors");
        } catch (Exception e) {
            log.error("Completed sum exceptionally.");
        } finally {
            log.info("Outer finally block at the very last!");
        }

        log.info("After outer try-catch-finally with sum {}", sum);
    }

}
