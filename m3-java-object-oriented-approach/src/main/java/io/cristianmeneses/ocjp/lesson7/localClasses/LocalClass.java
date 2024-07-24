package io.cristianmeneses.ocjp.lesson7.localClasses;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class LocalClass {

    private int x = 100;

    public String doStuff() {

        /**
         * Inner classes are scoped to the method where they are declared, and they cannot be seen outside that scope.
         * This means that doStuff cannot return a ReturnType instance.
         */
        class ReturnType {
            int code;
            String message;

            @Override
            public String toString() {
                return "ReturnType{" +
                        "code=" + code +
                        ", message='" + message + '\'' +
                        '}';
            }
        }

        ReturnType returnType = new ReturnType();
        returnType.code = x;
        returnType.message = "all good";
        return returnType.toString();
    }

    public Serializable doMoreStuff() {
        /**
         * If ReturnType implements a known interface. that is a viable option.
         */
        class ReturnType implements Serializable {
            int code;
            String message;

            @Override
            public String toString() {
                return "ReturnType{" +
                        "code=" + code +
                        ", message='" + message + '\'' +
                        '}';
            }
        }

        ReturnType returnType = new ReturnType();
        returnType.code = x;
        returnType.message = "all good";
        return returnType;
    }

    public static void main(String[] args) {
        log.info("Lesson 7 - Local classes.");
        LocalClass l = new LocalClass();
        log.info("{}", l.doStuff());
        log.info("{}", l.doMoreStuff());
        log.info("Lesson 7 - All done.");
    }
}
