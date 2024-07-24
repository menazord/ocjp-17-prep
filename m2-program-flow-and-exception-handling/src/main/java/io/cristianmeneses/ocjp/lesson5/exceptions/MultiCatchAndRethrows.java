package io.cristianmeneses.ocjp.lesson5.exceptions;

import lombok.extern.slf4j.Slf4j;

import javax.sound.midi.MidiUnavailableException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

@Slf4j
public class MultiCatchAndRethrows {

    public static void main(String[] args) throws Exception {
        log.info("Lesson 5 - Multi-catch and rethrowing.");
        MultiCatchAndRethrows t = new MultiCatchAndRethrows();
        t.multiCatch();

        try {
            t.rethrowSpecific();
        } catch (Exception e) {
            log.warn("Whoops, something went wrong at throwSpecific");
        }

        try {
            t.rethrowReassigned();
        } catch (Exception e) {
            log.warn("Whoops, something went wrong at throwReassigned");
        }

        log.info("Lesson 5 - All done");
    }

    public void multiCatch() {
        try {
            if (Math.random() > 0.5) {
                throw new FileNotFoundException("File not found!");
            }
            if (Math.random() > 0.6) {
                throw new MidiUnavailableException("Midi unavailable");
            }
        } catch (FileNotFoundException | MidiUnavailableException e) {
            log.error("Completed sum exceptionally.", e);
        } finally {
            log.info("Finally block at the very last!");
        }

        log.info("After try-catch-finally");
    }

    /**
     * In this example, the effective common ancestor of <code>(IOException | SQLException e)</code> will be <code>Exception</code>
     * and since e is final, there is no need to specify the generalized <code>IOException</code> in the throws clause,
     * but the specific exception being captured can be thrown instead.
     * The rules are:
     * <ul>
     *     <li>If the catch is a parent type, or a multi-catch, and</li>
     *     <li>the catch parameter variable is final or effectively final, and</li>
     *     <li>the thrown variable is the catch parameter</li>
     *     <li>then the throws declaration can be specific.</li>
     * </ul>
     *
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public void rethrowSpecific() throws SQLException, FileNotFoundException {
        try {
            if (Math.random() > 0.5) {
                throw new FileNotFoundException("File not found!");
            }
            if (Math.random() > 0.6) {
                throw new SQLException("Midi unavailable");
            }
        } catch (IOException | SQLException e) {
            log.error("Completed sum exceptionally.", e);
            throw e;
        } finally {
            log.info("Finally block at rethrowSpecific!");
        }
    }

    /**
     * In this example, the catch parameter is being re-assigned into a final variable of type Exception.
     * As per the rules explained above, the throws clause has to specify <code>Exception</code> is being thrown.
     * @throws Exception
     */
    public void rethrowReassigned() throws Exception {
        try {
            if (Math.random() > 0.5) {
                throw new FileNotFoundException("File not found!");
            }
            if (Math.random() > 0.6) {
                throw new SQLException("Midi unavailable");
            }
        } catch (IOException | SQLException e) {
            final Exception f = e;
            throw f;
        } finally {
            log.info("Finally block at rethrowReassigned!");
        }
    }
}
