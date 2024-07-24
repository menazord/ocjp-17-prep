// Package is always first. Whitespaces and comments are allowed.
package io.cristianmeneses.ocjp.lesson7.classDefinitions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassDefinition extends AbstractDefinition implements InterfaceDefinition {

    public static void main(String[] args) {
        log.info("Lesson 7 - Source files and basic type declarations.");
        ClassDefinition c = new ClassDefinition();
        c.doStuff();
        c.doMoreStuff();
        c.doEnumStuff();
        log.info("Lesson 7 - All done");

    }

    static {
        log.info("Static initializer");
    }

    {
        log.info("Instance initializer");
    }

    public ClassDefinition() {
        log.info("Constructor");
    }

    @Override
    public void doStuff() {
        log.info("Doing stuff with interface member x = {}", InterfaceDefinition.x);
    }

    @Override
    void doMoreStuff() {
        log.info("Doing more stuff with abstract member y = {}", y);
    }

    public void doEnumStuff() {
        for (EnumDefinition e: EnumDefinition.values()) {
            log.info(e.name());
        }
    }

    enum EnumDefinition {
        A, B, C;
    }
}
