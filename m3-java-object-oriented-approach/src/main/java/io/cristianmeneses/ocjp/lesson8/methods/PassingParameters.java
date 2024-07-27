package io.cristianmeneses.ocjp.lesson8.methods;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PassingParameters {

    public static void main(String[] args) {
        log.info("Lesson 8 - Instance and static methods");
        PassingParameters p = new PassingParameters();

        // Parameters passed by value (primitives) are copied, but not changed.
        int x = 100;
        log.info("Before changeValueType, x is {}", x);
        p.changeValueType(x);
        log.info("After changeValueType, x is {}", x);

        // Parameters passed by reference (Objects) pass a memory address of the target object, thus
        // obtaining a way to alter the target object itself. The memory address remains immutable.
        StringBuilder sb = new StringBuilder("Hello World!");
        log.info("Before changeReferenceType, sb is '{}'", sb);
        p.changeReferenceType(sb);
        log.info("After changeReferenceType, sb is '{}'", sb);

        Integer i = 10;
        log.info("Before changeUnboxedReference, i is {}", i);
        p.changeUnboxedReference(i);
        log.info("After changeUnboxedReference, i is {}", i);


        log.info("Lesson 8 - All done");
    }

    public void changeValueType(int x) {
        x+= 1000;
        log.info("Inside changeValueType, x is {}", x);
    }

    public void changeReferenceType(StringBuilder sb) {
        sb.append(".. OK bye!");
        log.info("Inside changeReferenceType, sb is '{}'", sb);

        // I cannot change the memory address sent by the invoker! Even after creating a new "sb",
        // the caller will still be able to see the original sb.
        sb = new StringBuilder();
        log.info("Inside changeReferenceType, created a new sb with value '{}'", sb);

        sb = null;
        log.info("Inside changeReferenceType, sb is now {}", sb);
    }

    public void changeUnboxedReference(Integer i) {
        // this will create a copy of i with value 2 (thanks to auto-unboxing) but does not change the original i.
        i += 1000;
        log.info("Inside changeUnboxedReference, i is {}", i);
    }

}
