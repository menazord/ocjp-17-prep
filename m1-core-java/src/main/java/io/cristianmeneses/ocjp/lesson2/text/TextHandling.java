package io.cristianmeneses.ocjp.lesson2.text;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextHandling {

    public static void main(String[] args) {

        log.info("Lesson 2 - Handling text.");
        TextHandling t = new TextHandling();
        t.pooling();
        t.textBlock();
        log.info("Lesson 2 - All done.");
    }

    public void pooling() {

        String s1 = "Hello";
        String s2 = "Hello";

        String s3 = "He";
        String s4 = s3 + "llo";

        final String s5 = "He";
        String s6 = s5 + "llo";

        String s7 = """
                Hello""";

        String s8 = """
                He\
                llo""";

        log.info("s1 == s2? " + (s1 == s2));
        log.info("s1 == s6? " + (s1 == s6));

        log.info("s1 == s4? " + (s1 == s4));

        s4 = s4.intern();
        log.info("s1 == s4? " + (s1 == s4));

        log.info("s1 == s7? " + (s1 == s7));
        log.info("s1 == s8? " + (s1 == s8));
    }

    public void textBlock() {

        String js = """
                let x = 10
                console.log(`value ${x}`)
                """;
        log.info(js);
    }
}
