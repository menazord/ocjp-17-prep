package io.cristianmeneses.ocjp.lesson8.methods;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReceiverParameter {

    private final String aString;
    public ReceiverParameter(String aString) {
        this.aString = aString;
    }

    public static void main(String[] args) {
        log.info("Lesson 8 - Instance and static methods.");
        ReceiverParameter r = new ReceiverParameter("wow");
        r.doStuff("yeah");
        r.doStuff2("alright"); // 'this' is implicit !
        r.doStuff3(r,"c'mon"); // 'if receiver is not called 'this' you actually need to pass it
        log.info("Lesson 8 - All done.");
    }

    public void doStuff(String s) {
        log.info("doStuff: s is {} with aString {}", s, this.aString);
    }

    /**
     * Using <code>this</code> as an argument will allow you to annotate it.
     */
    public void doStuff2(@NonNull ReceiverParameter this, String s) {
        log.info("doStuff2: s is {} with aString {}", s, this.aString);
    }

    public void doStuff3(@NonNull ReceiverParameter that, String s) {
        log.info("doStuff2: s is {} with aString {}", s, that.aString);
    }
}
