package io.cristianmeneses.ocjp.lesson8.overloading;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Slf4j
public class Overload {

    /**
     * Overload resolution rules
     * 1. Perfect match of argument type and count always wins
     *    - Widening promotions may be applied
     *    - Look for the nearest/shortest promotion
     *    - ambiguity causes compilation failure
     * 2. Autoboxing/unboxing may be tried
     *    - will not change basic type
     *    - ambiguity causes compilation failure
     * 3. Varargs may be tried
     *    - ambiguity causes compilation failure
     */
    public static void main(String[] args) {
        log.info("Lesson 8 - Overloaded and overwritten methods.");

        new OverloadOne().doStuff(99, 100);

        // code below is ambiguous, since either x or y can be promoted to long, hence two methods would satisfy the call.
        //new OverloadTwo().doStuff(99, 100);

        // auto-boxing both int values to Integer is the shortest/nearest path
        new OverloadThree().doStuff(99, 100);

        // Can't auto-box char 'A' to either Long or Integer, but it can be promoted to int
        new OverloadThree().doStuff(99, 'A');

        log.info("Lesson 8 - All done.");
    }
}

@Slf4j
class OverloadOne {
    public void doStuff(int x, long y) {
        log.info("Chose doStuff(int {}, long {})", x, y);
    }

    public void doStuff(long x, long y) {
        log.info("Chose doStuff(long {}, long {})", x, y);
    }

    public void doStuff(int x, int... y) {
        log.info("Chose doStuff(int {}, int... {})", x, y);
    }
}

@Slf4j
class OverloadTwo {
    public void doStuff(int x, long y) {
        log.info("Chose doStuff(int {}, long {})", x, y);
    }

    public void doStuff(long x, int y) {
        log.info("Chose doStuff(long {}, int {})", x, y);
    }

    public void doStuff(int x, int... y) {
        log.info("Chose doStuff(int {}, int... {})", x, y);
    }
}

@Slf4j
class OverloadThree {
    public void doStuff(int x, Long y) {
        log.info("Chose doStuff(int {}, Long {})", x, y);
    }

    public void doStuff(Integer x, Integer y) {
        log.info("Chose doStuff(Integer {}, Integer {})", x, y);
    }

    public void doStuff(int x, int... y) {
        log.info("Chose doStuff(int {}, int... {})", x, y);
    }
}

/*

Generics are not considered for method overloading, so a List<A> and a List<B> are basically a plain List
to the eyes of the compiler, and compilation will fail. Uncomment to see this yourself!

@Slf4j
class OverloadFour {
    public void doStuff(List<String> s) {
        log.info("Chose doStuff(List<String> {}})", s);
    }

    public void doStuff(List<CharSequence> s) {
        log.info("Chose doStuff(List<CharSequence> {}})", s);
    }

    public void doStuff(ArrayList<String> s) {
        log.info("Chose doStuff(ArrayList<String> {}})", s);
    }

    public void doStuff(ArrayList<Date> s) {
        log.info("Chose doStuff(ArrayList<Date> {}})", s);
    }

    public void doStuff(Collection<CharSequence> s) {
        log.info("Chose Collection<CharSequence> {}})", s);
    }
}

*/