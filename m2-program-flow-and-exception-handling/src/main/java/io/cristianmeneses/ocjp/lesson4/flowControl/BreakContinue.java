package io.cristianmeneses.ocjp.lesson4.flowControl;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class BreakContinue {

    public static void main(String[] args) {
        log.info("Lesson 4 - Control using break and continue.");
        BreakContinue b = new BreakContinue();
        b.compare();
        b.labeledStatements();
        log.info("Lesson 4 - All done");
    }

    public void compare() {
        Set<String> names = Set.of("Michael", "Dwight", "Jim");
        for (String n : names) {
            if ("Dwight".equals(n))
                break;
            log.info("break: {}", n);
        }

        for (String n : names) {
            if ("Dwight".equals(n))
                continue;
            log.info("continue: {}", n);
        }
    }

    public void labeledStatements() {

        outer: for (int i = 0; i < 4; i++) {
            inner: for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue outer;
                    // break and break inner would also work.
                }
                log.info("{} - {}", i, j);
            }
        }
    }
}
