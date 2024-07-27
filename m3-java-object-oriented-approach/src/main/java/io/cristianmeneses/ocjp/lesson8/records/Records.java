package io.cristianmeneses.ocjp.lesson8.records;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Records {

    public static void main(String[] args) {
        log.info("Lesson 8 - Defining records");
        Records r = new Records();
        r.createCustomerRecords();
        r.createNamePairRecords();
        r.createMutableRecord();
        r.createCustomRecord();
        log.info("Lesson 8 - All done.");
    }

    public void createCustomerRecords() {
        Customer c1 = new Customer("Fred", 1000);
        log.info("Record of type [{}] is {}", c1.getClass().getName(), c1);
        log.info("Name is {} and limit is {}", c1.name(), c1.creditLimit());

        Customer c2 = new Customer("Fred", 1000);
        Customer c3 = new Customer("Freddy", 1000);

        log.info("c1.equals(c2) == {}", c1.equals(c2));
        log.info("c1.equals(c3) == {}", c1.equals(c3));

        log.info("c1.hashCode() {}", c1.hashCode());
        log.info("c2.hashCode() {}", c2.hashCode());
        log.info("c3.hashCode() {}", c3.hashCode());
    }

    public void createNamePairRecords() {
        NamePair n = new NamePair("Cristian", "Meneses");
        log.info("Record type [{}] is {}", n.getClass().getName(), n);
        log.info("Name is {} and Last name is {}", n.first(), n.last());
    }

    public void createMutableRecord() {
        Mutable m1 = new Mutable(new StringBuilder("Fred"));
        Mutable m2 = new Mutable(new StringBuilder("Fred"));

        // StringBuilder does not implement equals and relies on object. Since both StringBuilders point to different
        // locations in memory, they are not equal.
        log.info("m1.equals(m2) = {}", m1.equals(m2));

        // This will definitely be true, since the same StringBuilder (the same pointer) is used on both records.
        StringBuilder sb = new StringBuilder("Fred");
        Mutable m3 = new Mutable(sb);
        Mutable m4 = new Mutable(sb);
        log.info("m3.equals(m4) = {}", m3.equals(m4));

        // Record itself is immutable, but values inside of it can be mutable, like this example.
        m2.name().append("dy");
        log.info("m2 = {}", m2.name());
    }

    public void createCustomRecord() {
        Customized c = new Customized("hello");
        log.info("Record's type is [{}] and value is {}", c.getClass().getName(), c.data);

        Customized c2 = new Customized();
        log.info("Record's type is [{}] and value is {}", c2.getClass().getName(), c2.data);
    }

    record Customer(String name, int creditLimit){}

    interface FirstNameable {
        String first();
    }

    interface LastNameable {
        String last();
    }

    // Records can implement interfaces, but they can't be extended because they are implicitly final
    record NamePair(String first, String last) implements FirstNameable, LastNameable {}

    record Mutable(StringBuilder name) {}

    @Slf4j
    record Customized(String data) {

        // Compact constructor. Any code in here is "rolled over" to the canonical, auto-generated constructor.
        // Compact constructors are not allowed to refer to fields.
        Customized {
            log.info("Compact constructor starting!");
        }

        // Non-canonical constructors MUST DELEGATE to a canonical constructor, and it must be the first line.
        public Customized() {
            this(DEFAULT);
            log.info("No args constructor, delegating default value");
        }

        // static initializers are allowed. Instance initializers are not.
        static {
            log.info("Static initialization of record type Customized.");
        }

        // Static fields are also allowed. Instance fields are not.
        static final int X = 10;
        static final String DEFAULT = "DEFAULT";

        @Override
        public String data() {
            log.info("Returning data {} with X {}", data, X);
            return data;
        }

        // Static methods are also allowed
        public static String saySomething() {
            return "X is " + X;
        }

    }
}

