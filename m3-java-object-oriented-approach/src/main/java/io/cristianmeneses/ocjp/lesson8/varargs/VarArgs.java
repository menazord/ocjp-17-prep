package io.cristianmeneses.ocjp.lesson8.varargs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class VarArgs {

    public static void main(String[] args) {
        log.info("Lesson 8 - Variable length argument handling");
        VarArgs v = new VarArgs();
        v.changeReferenceTypeVarargs();
        v.changeValueTypeVarargs();
        log.info("Lesson 8 - All done");
    }

    /**
     * For reference types, rules are the same as other reference parameters.
     * Changes are local, but the caller will still see the original array.
     */
    public void changeReferenceTypeVarargs() {
        String []names = {"Michael", "Jim", "Pam"};
        process(names);
        log.info("Names are {}", Arrays.toString(names));
    }

    /**
     * As you might expect, value types can actually be changed.
     */
    public void changeValueTypeVarargs() {
        int []values = {1, 2, 3};
        process(values);
        log.info("Values are {}", Arrays.toString(values));
    }

    private void process(String... v) {
        v[1] = "The name is James";
    }

    private void process(int ... v) {
        v[1] = 1000;
    }

}
