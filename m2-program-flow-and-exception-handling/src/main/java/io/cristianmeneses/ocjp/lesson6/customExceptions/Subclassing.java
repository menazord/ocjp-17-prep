package io.cristianmeneses.ocjp.lesson6.customExceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Subclassing {

    public static void main(String[] args) {
        log.info("Lesson 6 - Subclassing throwable types.");
        Subclassing s = new Subclassing();

        try {
            s.testChecked();
            log.info("Hooray, no checked exceptions occurred!");
        } catch (CustomCheckedException e) {
            log.error("Exception (checked) caught: [{}]:{}", e.getClass().getName(), e.getMessage());
        }

        try {
            s.testUnchecked();
            log.info("Yay, no unchecked exceptions occurred!");
        } catch (RuntimeException e) {
            log.error("Runtime exception (unchecked) caught: [{}]:{}", e.getClass().getName(), e.getMessage());
        }

        try {
            s.testError();
            log.info("Awesome, no errors occurred!");
        } catch (Error e) {
            log.error("Error (unchecked) caught: [{}]:{}", e.getClass().getName(), e.getMessage());
        }
        log.info("Lesson 6 - All done");
    }

    public void testChecked() throws CustomCheckedException {
        if (Math.random() > 0.5) {
            throw new CustomCheckedException("A random error occurred");
        }
    }

    /**
     * No catch here, but the exception (if happens) will interrupt the program.
     */
    public void testUnchecked() {
        if (Math.random() > 0.5) {
            throw new CustomUncheckedException("A random error occurred");
        }
    }

    /**
     * No catch here, but the exception (if happens) will interrupt the program.
     */
    public void testError() {
        if (Math.random() > 0.5) {
            throw new CustomError("A random error occurred");
        }
    }


    /**
     * When you need a checked exception, it's a good idea to extend from Exception, which will make it checked
     * by default. Exceptions describe errors that can be recoverable.
     */
    public static class CustomCheckedException extends Exception {
        public CustomCheckedException() {
        }

        public CustomCheckedException(String message) {
            super(message);
        }

        public CustomCheckedException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * When you need an unchecked exception, it's a good idea to extend from RuntimeException, which will make it
     * unchecked by default. Unchecked exceptions don't need to be explicitly caught. RuntimeExceptions usually describe
     * software bugs.
     */
    static class CustomUncheckedException extends RuntimeException {
        public CustomUncheckedException() {
        }

        public CustomUncheckedException(String message) {
            super(message);
        }

        public CustomUncheckedException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * For unrecoverable problems, extend from Error instead. Errors usually describe catastrophic situations such as
     * out of memory problems.
     */
    static class CustomError extends Error {
        public CustomError() {
        }

        public CustomError(String message) {
            super(message);
        }

        public CustomError(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
