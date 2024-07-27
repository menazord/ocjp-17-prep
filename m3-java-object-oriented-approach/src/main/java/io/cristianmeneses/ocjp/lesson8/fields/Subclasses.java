package io.cristianmeneses.ocjp.lesson8.fields;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Subclasses {

    public static void main(String[] args) {
        log.info("Lesson 8 - Instance and static fields");
        Subclasses s = new Subclasses();
        s.test();
        log.info("Lesson 8 - All done.");
    }

    public void test() {
        X x = new Y();
        log.info("{} : {}", x.name, ((Y)x).name);
    }
}

class X {
    String name = "X";
}

class Y extends X {
    String name = "Y";
}