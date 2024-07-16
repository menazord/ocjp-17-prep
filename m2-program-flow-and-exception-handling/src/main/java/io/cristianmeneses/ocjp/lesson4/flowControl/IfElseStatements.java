package io.cristianmeneses.ocjp.lesson4.flowControl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IfElseStatements {

    public static void main(String[] args) {
        log.info("Lesson 4 - Using if/else statements.");
        IfElseStatements i = new IfElseStatements();
        i.elseBinding();
        log.info("Lesson 4 - All done.");
    }

    /**
     * This piece produces no output. The else statement is not ruled by indentation,
     * but instead it binds itself to the closest <code>if</code>, which in this case
     * is <code>if (x > 90)</code>
     */
    public void elseBinding() {

        int x = 40;
        if (x > 50)
            if (x > 90)
                log.info("Very big");
        else
            log.info("How big");

    }
}
