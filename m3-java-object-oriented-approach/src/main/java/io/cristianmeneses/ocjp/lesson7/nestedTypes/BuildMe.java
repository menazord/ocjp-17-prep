package io.cristianmeneses.ocjp.lesson7.nestedTypes;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

public class BuildMe {
    private String name;
    private LocalDate date;

    private BuildMe() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        // private constructor, but I can still access it inside the top level curly braces
        private BuildMe template = new BuildMe();

        private Builder() {
        }

        // private fields name and date, but I can still access it inside the top level curly braces
        public Builder name(String name) {
            template.name = name;
            return this;
        }

        public Builder date(LocalDate date) {
            template.date = date;
            return this;
        }

        public BuildMe build() {
            BuildMe rv = template;
            template = null;
            return rv;
        }
    }

    @Override
    public String toString() {
        return "BuildMe{" +
                "name=" + name +
                ", date=" + date +
                "}";
    }
}

@Slf4j
class TryBuilder {

    public static void main(String[] args) {

        log.info("Lesson 7 - Nested type declarations.");

        BuildMe bm = BuildMe.builder()
                .name("Cristian")
                .date(LocalDate.now())
                .build();
        log.info(bm.toString());

        //bm.name -->  I can't access name or date here, since I am outside the enclosing curly braces of BuildMe :(
        log.info("Lesson 7 - All done");

    }
}

