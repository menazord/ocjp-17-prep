package io.cristianmeneses.ocjp.lesson7.anonymousClasses;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnonymousClass {

    public static void main(String[] args) {
        log.info("Lesson 7 - Anonymous classes.");

        Runnable r1 = new MyRunnable();
        r1.run();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                log.info("Hello from anonymous runnable");
            }
        };
        r2.run();

        // With args
        Runnable r3 = new MyAbstractRunnable("awesome") {
            @Override
            public void run() {
                log.info("Hello from an {} anonymous runnable with constructor args", message);
            }
        };
        r3.run();

        log.info("Lesson 7 - All done.");
    }

}

@Slf4j
class MyRunnable implements Runnable {
    @Override
    public void run() {
        log.info("Hello from MyRunnable");
    }
}

@Slf4j
abstract class MyAbstractRunnable implements Runnable {
    String message;
    MyAbstractRunnable(String s) {
        message = s;
    }
}

