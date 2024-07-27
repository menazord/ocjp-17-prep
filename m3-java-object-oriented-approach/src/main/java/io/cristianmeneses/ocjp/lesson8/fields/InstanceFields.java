package io.cristianmeneses.ocjp.lesson8.fields;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstanceFields extends Parent {
    int x = 200;

    public void go() {
        log.info("InstanceFields's version of x is {}", x);
        log.info("Parent's version of x is {}", super.x);
        Parent p = this;
        log.info("p type is [{}] and p.x is {}", p.getClass().getName(), p.x);
    }

    public static void main(String[] args) {
        log.info("Lesson 8 - Instance and static fields");
        InstanceFields i = new InstanceFields();
        i.go();
        log.info("Lesson 8 - All done");
    }
}

class Parent {
    public int x = 100;
}

