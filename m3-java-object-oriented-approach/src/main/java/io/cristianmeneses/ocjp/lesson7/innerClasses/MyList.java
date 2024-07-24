package io.cristianmeneses.ocjp.lesson7.innerClasses;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MyList<E> implements Iterable<E> {
    private E[] data = (E[]) (new Object[10]);
    private int count = 0;

    public void add(E e) {
        data[count++] = e;
    }

    @Override
    public String toString() {
        return Arrays.stream(data)
                .limit(count)
                .map(Object::toString)
                .collect(Collectors.joining(",", "MyList[", "]"));
    }

    private class MyListIterator implements Iterator<E> {

        private int progress = 0;

        @Override
        public boolean hasNext() {
            return progress < count;
        }

        @Override
        public E next() {
            return data[progress++];
        }
    }

    /**
     * This constructor as an implicit, immutable relationship with its enclosing object,
     * meaning that this iterator instance will be tied to the enclosing MyList that created it and this
     * relation cant be changed.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        // return this.new MyListIterator();   --> this would also work, just more explicitly written.
        return new MyListIterator();
    }
}

@Slf4j
class TryList {
    public static void main(String[] args) {
        log.info("Lesson 7 - Inner class declarations.");

        MyList<String> ml1 = new MyList<>();
        MyList<String> ml2 = new MyList<>();
        ml1.add("One");
        ml1.add("Two");
        ml1.add("Three");
        ml2.add("Uno");
        ml2.add("Dos");
        ml2.add("Tres");
        log.info("ml1 contents = {}", ml1.toString());
        log.info("ml2 contents = {}", ml2.toString());

        for (String s : ml1) {
            log.info("ml1 - {}", s);
        }

        for (String s : ml2) {
            log.info("ml2 - {}", s);
        }

        log.info("Lesson 7 - All done");
    }


}
