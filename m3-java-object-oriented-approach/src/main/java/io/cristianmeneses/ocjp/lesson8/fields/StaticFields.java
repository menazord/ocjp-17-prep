package io.cristianmeneses.ocjp.lesson8.fields;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticFields {

    static int x = 99;

    public static void main(String[] args) {
        log.info("Lesson 8 - Instance and static fields");
        StaticFields s = new StaticFields();
        s.staticAccess();
        log.info("Lesson 8 - All done.");
    }

    public void staticAccess() {
        StaticFields s1 = new StaticFields();
        StaticFields s2 = new StaticFields();
        s1.x++;  // static fields can be accessed through an instance variable! X_x
        s2.x++;  // ugly, bad style, but legal.
        s1.x++;  // Not applicable to static methods though!
        log.info("Value of x is {}", StaticFields.x);
    }
}
