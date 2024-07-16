package io.cristianmeneses.ocjp.lesson4.flowControl;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class SimpleLoops {

    public static void main(String[] args) {
        log.info("Lesson 4 - Simple loops.");
        SimpleLoops s = new SimpleLoops();
        s.basicWhile();
        s.basicDoWhile();
        s.basicFor();
        s.enhancedFor();
        log.info("Lesson 4 - All done");
    }

    public void basicWhile() {
        int i = 0;
        while (i < 2) {
            log.info("basic while: i is {}", i);
            i++;
        }
        log.info("All done - basic while");
    }

    public void basicDoWhile() {
        int i = 0;
        do {
            log.info("basic do-while: i is {}", i);
            i++;
        } while (i <= 0);
        log.info("All done - basic do-while");
    }

    public void basicFor() {

        for (int i = 0, j = 1, k = 2; i < 3; i++, j+=2, k--) {
            log.info("basic for, i:{}, j:{}, k:{}", i, j, k);
        }
        log.info("All done - basic for");
    }

    public void enhancedFor() {
        Set<String> names = Set.of("Michael", "Dwight", "Jim", "Pam", "Ryan");
        int i = 1;
        for (String n: names) {
            log.info("{} - {}", i++, n);
        }

        log.info("All done - enhanced for");
    }
}
