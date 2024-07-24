package io.cristianmeneses.ocjp.lesson5.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

@Slf4j
public class ImplementingAutoCloseable {

    public static void main(String[] args) {
        log.info("Lesson 5 - Implementing auto-closeable.");
        ImplementingAutoCloseable i = new ImplementingAutoCloseable();
        i.autoCloseWithoutThrowsClause();
        i.autoCloseWithThrowsClause();
        i.autoCloseWithCloseable();
        i.autoCloseOrder();
        i.autoCloseOrderWithExternal();
        i.autoCloseWithExceptionsOnClose();
        log.info("Lesson 5 - All done");

    }

    public void autoCloseWithoutThrowsClause() {
        log.info("Before creating instance of ResourceOne");
        try (ResourceOne i = new ResourceOne()) {
            log.info("Using resources");
        }
        log.info("Leaving");
    }

    public void autoCloseWithThrowsClause() {
        log.info("Before creating instance of ResourceTwo");
        try (ResourceTwo i = new ResourceTwo()) {
            log.info("Using resources");
        } catch (SQLException e) {
            log.error("Something went wrong closing ResourceTwo");
        }
        log.info("Leaving");
    }

    public void autoCloseWithCloseable() {
        log.info("Before creating instance of ResourceThree");
        try (ResourceThree i = new ResourceThree()) {
            log.info("Using resources");
        } catch (IOException e) {
            log.error("Something went wrong closing ResourceThree");
        }
        log.info("Leaving");
    }

    public void autoCloseOrder() {
        log.info("Before creating instances of ResourceFour");
        try (ResourceFour rf1 = new ResourceFour();
             ResourceFour rf2 = new ResourceFour();
             ResourceFour rf3 = new ResourceFour();
             ResourceFour rf4 = new ResourceFour()) {
            log.info("Using resources");
        }
        log.info("Leaving");
    }

    public void autoCloseOrderWithExternal() {
        log.info("Before creating instances of ResourceFour");
        ResourceFour rf0 = new ResourceFour();

        try (ResourceFour rf1 = new ResourceFour();
             ResourceFour rf2 = new ResourceFour();
             rf0; // just referencing it to have it auto-closed, even if not created here
             ResourceFour rf3 = new ResourceFour()) {
            log.info("Using resources");
        }
        log.info("Leaving");
    }

    public void autoCloseWithExceptionsOnClose() {
        log.info("Before creating instance of ResourceFive");
        try (ResourceFive rf1 = new ResourceFive();
             ResourceFive rf2 = new ResourceFive();
             ResourceFive rf3 = new ResourceFive();
             ResourceFive rf4 = new ResourceFive()) {
            log.info("Using resources");
            if (Math.random() > 0.5) {
                log.error("Error on main try block");
                throw new FileNotFoundException("Whoops");
            }

        } catch (Exception e) {
            log.error("Got error - {}:{}", e.getClass().getName(), e.getMessage());
            if (e.getSuppressed() != null && e.getSuppressed().length > 0) {
                log.error("Got more exceptions!");
                for (Throwable t: e.getSuppressed()) {
                    log.error("Got suppressed error - {}:{}", t.getClass().getName(), t.getMessage());
                }
            }
        }
        log.info("Leaving");
    }

    /**
     * Even when the AutoCloseable interface declares a <code>void close() throws Exception</code> signature, there is no
     * need to declare a throws clause when implementing it.
     */
    static class ResourceOne implements AutoCloseable {
        @Override
        public void close() {
            log.info("Closing resources");
        }
    }

    /**
     * If you decide to declare a throws clause when implementing it, you are encouraged to use concrete types instead
     * of the more generalized Exception type.
     */
    static class ResourceTwo implements AutoCloseable {
        @Override
        public void close() throws SQLException {
            log.info("Closing resources");
        }
    }

    /**
     * While you cvan also use <code>Closeable</code> implementations inside try-with-resources, these implementations
     * can only throw <code>IOException</code>.
     */
    static class ResourceThree implements Closeable {
        @Override
        public void close() throws IOException {
            log.info("Closing resources");
        }
    }

    /**
     * A try-with-resources will auto-close resources in the reverse order they were declared inside the try block.
     */
    static class ResourceFour implements AutoCloseable {

        private static int nextId = 0;
        private final int id = nextId++;
        {
            log.info("Initializing ResourceFour with id {}", id);
        }

        @Override
        public void close()  {
            log.info("Closing resources for id {}", id);
        }
    }

    /**
     * A<code>close()</code> method implementation of <code>AutoCloseable</code> can throw exceptions, but
     * that will not prevent other resources from being closed.
     */
    static class ResourceFive implements AutoCloseable {

        private static int nextId = 0;
        private final int id = nextId++;
        {
            log.info("Initializing ResourceFive with id {}", id);
        }

        @Override
        public void close() throws SQLException {
            log.info("Closing resources for id {}", id);
            if (Math.random() > 0.5) {
                log.error("Failure to close resources for id {}", id);
                throw new SQLException("Could not close " + id);
            }
            log.info("Resources for {} closed successfully", id);
        }
    }

}
