package io.cristianmeneses.ocjp.lesson8.fields;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticInitializers {

    // Static initializers can be declared before variables. Since loading a class involves allocating memory for
    // class variables, it's ok, but only as long as a qualified variable name is used instead.
    static {
        log.info("static 0 - value of count is {}", StaticInitializers.count);
    }
    static int count;

    // Static initializers are executed when the class is loaded, and they run from top to bottom, in the order
    // they were declared in the class.
    static {
        log.info("static 1 - value of count is {}", count);
        count = 99;
    }

    public static void main(String[] args) {
        log.info("Lesson 8 - Instance and static fields");
        log.info("main - count is {}", StaticInitializers.count);
        log.info("Lesson 8 - All done.");
    }

    static {
        log.info("static 2 - count is now {}", count);
    }
}
