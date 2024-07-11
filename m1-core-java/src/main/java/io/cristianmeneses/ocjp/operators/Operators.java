package io.cristianmeneses.ocjp.operators;

public class Operators {

    public static void main(String[] args) {

        System.out.println("Operations and Core data types.");
        incrementsAndDecrements();
        remainder();
        equalityTest();
        assignmentValue();
        casting();
        wrappers();
        aliasing();
        System.out.println("All done.");
    }

    /**
     * Increments
     * Pre-increments are applied before the value is evaluated.
     * Post-increments are applied after the value is evaluated.
     * Same rules apply for pre- and post- decrements.
     */
    private static void incrementsAndDecrements() {
        System.out.println("Pre/Post increments and decrements.");

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
    private static void remainder() {
        System.out.println("Remainder (%) operator.");
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
    private static void equalityTest() {
        System.out.println("Equality test.");
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
    private static void assignmentValue() {
        System.out.println("Assignments value.");

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
    private static void casting() {
        System.out.println("Casting.");

        Animal aDog = new Dog();
        Animal aRacoon = new Raccoon();

        // Down casting
        try {
            Dog dog = (Dog) aDog;
            Raccoon raccoon = (Raccoon) aRacoon;
        } catch (Exception e) {
            System.out.println("Could not down cast!");
            e.printStackTrace();
        }

        // Cross casting
        try {
            Dog dog = (Dog) aRacoon;
        } catch (Exception e) {
            System.out.println("Could not cross cast!");
            e.printStackTrace();
        }

        // Interface casting
        try {
            Walk dog = (Dog) aDog;
            Walk raccoon = (Raccoon) aRacoon;
        } catch (Exception e) {
            System.out.println("Could not interface cast!");
            e.printStackTrace();
        }
    }

    /**
     * Wrapper classes.
     * There are wrapper classes for each primitive type in Java.
     * JVM will automatically box/unbox a primitive to/from a wrapper type if required.
     */
    private static void wrappers() {
        System.out.println("Wrapper classes, auto-boxing and auto-unboxing.");

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
    private static void aliasing() {
        System.out.println("Aliasing.");

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

    private static interface Walk {

    }
    private static class Animal {
        private String name;

    }

    private static class Dog extends Animal implements Walk {
        private String breed;
    }

    private static class Raccoon extends Animal implements Walk {
        private int age;
    }
}
