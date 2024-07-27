package io.cristianmeneses.ocjp.lesson8.overriding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Overriding {

    /**
     * Overriding rules
     * If a method has the exact same name and same argument type sequence
     * - and both methods are instance methods, then this is an attempt of overriding
     * or
     * - if both methods are static and the parent is a class, then this is an attempt of hiding.
     * - final methods can't be overridden or hidden
     */

    public static void main(String[] args) {
        log.info("Lesson 8 - Overloaded and overwritten methods.");
        Overriding o = new Overriding();
        o.behaviour();
        log.info("Lesson 8 - All done.");
    }

    public void behaviour() {

        /*
         * Late / dynamic binding
         * If a reference variable of Parent type refers to an object of Child type,
         * when an overridden instance method is invoked, the behaviour is that defined in Child class.
         *
         * This ONLY happens with overloaded instance methods., not static methods or any kind of fields.
         */

        Parent p = new Parent();
        // this will execute Parent.satSomething()
        p.saySomething();
        // this will show Parent.x
        log.info("Parent p of type [{}] has an x value of {}", p.getClass().getName(), p.x);

        Parent p2 = new Child();
        // Due to late binding, this will execute Child.saySomething() instead
        p2.saySomething();
        // but this will still show Parent.x
        log.info("Parent p2 of type [{}] has an x value of {}", p2.getClass().getName(), p2.x);
    }
}

@Slf4j
class Parent {
    int x = 100;

    public void saySomething() {
        log.info("Parent says hi with x value {}!", x);
    }
}

@Slf4j
class Child extends Parent {
    int x = 999;

    @Override
    public void saySomething() {
        log.info("Child says hi with x value {}!", x);
    }
}

