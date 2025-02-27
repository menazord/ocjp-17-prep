package io.cristianmeneses.ocjp.lesson1.operators;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Operators {

    public static void main(String[] args) {

        log.info("Lesson 1 - Operations and Core data types.");
        Operators o = new Operators();
        o.incrementsAndDecrements();
        o.remainder();
        o.equalityTest();
        o.assignmentValue();
        o.casting();
        o.wrappers();
        o.aliasing();
        log.info("Lesson 1 - All done.");
    }

    /**
     * Increments
     * Pre-increments are applied before the value is evaluated.
     * Post-increments are applied after the value is evaluated.
     * Same rules apply for pre- and post- decrements.
     */
    public void incrementsAndDecrements() {
        log.info("Pre/Post increments and decrements.");

        // Increments
        int pre = 10;

        assert ++pre == 11;
        assert pre == 11;

        int post = 10;

        assert post++ == 10;
        assert post == 11;

        // Decrements
        assert --pre == 10;
        assert post-- == 11;
    }

    /**
     * Remainder
     * Not the same as modulus.Java remainder operator takes the sign of the left
     * side operator and ignores the sign of the right side operator.
     */
    public void remainder() {
        log.info("Remainder (%) operator.");
        assert 7 % 3 == 1;
        assert -7 % 3 == -1;
        assert 7 % -3 == 1;
        assert -7 % -3 == -1;
    }

    /**
     * Equality test.
     * Equality for primitive types can be tested with ==.
     * However, for reference types, the Object.equals() method proves to be more effective
     * if it has been properly overridden.
     */
    public void equalityTest() {
        log.info("Equality test.");
        int a = 10, b = 10;

        assert a == b;

        String one = "A string value";
        String two = "A string value";

        assert one != two;
        assert one.equals(two);
    }

    /**
     * Assignment value.
     * In Java, an assignment operator (=) takes the value of the right side of the assignment.
     * So, for an expression such as x =10, the value of this expression is also 10.
     */
    public void assignmentValue() {
        log.info("Assignments value.");

        int x = 0;
        assert (x = 10) == 10;

        int []ia1 = {0, 1, 2, 3};
        int []ia2 = {10, 20, 30, 40};
        int []ia = {};

        assert ( (ia = ia2)[x=3]) == 40;

    }

    /**
     * Casting.
     * Down type casting is allowed and usually succeeds, unless the cast type does not have an is-a relationship.
     * Up casting always succeeds and it's redundant.
     * Cross-casting (across class hierarchy) will fail.
     * Reference type casting usually works by finding the least common ancestor on the hierarchy tree. If types
     * extend the same classes and implement the same interfaces, then the least common ancestor is a mix of both,
     * although the type can't be used as an assignment.
     */
    public void casting() {
        log.info("Casting.");

        Animal aDog = new Dog();
        Animal aRacoon = new Raccoon();

        // Down casting
        try {
            Dog dog = (Dog) aDog;
            Raccoon raccoon = (Raccoon) aRacoon;
        } catch (Exception e) {
            log.error("Could not down cast!", e);
        }

        // Cross casting
        try {
            Dog dog = (Dog) aRacoon;
        } catch (Exception e) {
            log.error("Could not cross cast!", e);
        }

        // Interface casting
        try {
            Walk dog = (Dog) aDog;
            Walk raccoon = (Raccoon) aRacoon;
        } catch (Exception e) {
            log.error("Could not interface cast!", e);
        }
    }

    /**
     * Wrapper classes.
     * There are wrapper classes for each primitive type in Java.
     * JVM will automatically box/unbox a primitive to/from a wrapper type if required.
     */
    public void wrappers() {
        log.info("Wrapper classes, auto-boxing and auto-unboxing.");

        int a = 10;
        Integer b = a;
        Long l = new Long(a);
        Long m = new Long(b);
        Double d = new Double(a);

        assert Double.isNaN(Double.parseDouble("NaN"));
        assert !Double.isFinite(Double.parseDouble("NaN"));
        assert !Double.isInfinite(Double.parseDouble("NaN"));
    }

    /**
     * Aliasing.
     * Primitive variables hold the actual value in memory, and using '==' equality will compare these values correctly.
     * For reference types, the variable points to a space in memory where the actual value is stored.
     *
     */
    public void aliasing() {
        log.info("Aliasing.");

        int a = 10;
        int b = a;
        assert a == b;


        // Both variables "reference" the same object.
        String s1 = "Hello";
        String s2 = s1;

        assert s1 == s2;

        // s2 reference is overwritten, and now points to a different String value somewhere in memory.
        s2 = s2.concat(" world!");
        assert s1 != s2;

        //
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = sb1;
        assert sb1 == sb2;

        sb1.append(" world!");
        assert sb1 == sb2;
    }

    public interface Walk {

    }
    public class Animal {
        private String name;

    }

    public class Dog extends Animal implements Walk {
        private String breed;
    }

    public class Raccoon extends Animal implements Walk {
        private int age;
    }
}
