package io.cristianmeneses.ocjp.text;

public class TextHandling {

    public static void main(String[] args) {

        System.out.println("Handling text.");
        pooling();
        textBlock();
        System.out.println("All done.");
    }

    private static void pooling() {

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

        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 == s6? " + (s1 == s6));

        System.out.println("s1 == s4? " + (s1 == s4));

        s4 = s4.intern();
        System.out.println("s1 == s4? " + (s1 == s4));

        System.out.println("s1 == s7? " + (s1 == s7));
        System.out.println("s1 == s8? " + (s1 == s8));
    }

    private static void textBlock() {

        String js = """
                let x = 10
                console.log(`value ${x}`)
                """;
        System.out.println(js);
    }
}
