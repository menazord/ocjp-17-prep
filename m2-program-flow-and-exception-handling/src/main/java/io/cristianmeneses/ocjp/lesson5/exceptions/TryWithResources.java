package io.cristianmeneses.ocjp.lesson5.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class TryWithResources {


    public static void main(String[] args) throws Exception {
        log.info("Lesson 5 - Flow control with try-with-resources.");
        TryWithResources t = new TryWithResources();
        t.tryWithTemporaryFile();
        log.info("Lesson 5 - All done");
    }

    public void tryWithTemporaryFile() throws IOException {

        log.info("Entering try-with-resources");
        File temp = File.createTempFile("temp", "001");
        try (FileReader r = new FileReader(temp);
             BufferedReader br = new BufferedReader(r)) {
            log.info("Reading temp file {}", temp.getAbsolutePath());
            String s;
            while ((s = br.readLine()) != null) {
                log.info("Read - {}", s);
            }
            log.info("Completed try block");
        } finally {
            log.info("Entering custom finally block");
            log.info("Deleted temp file ? {}", temp.delete());
        }
        log.info("Exited try-with-resources");

    }
}
