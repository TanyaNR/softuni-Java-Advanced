package Advanced.O8_IteratorsAndComparators.E03_StackIterator;

import java.util.*;

public class StackIterator implements Iterable<String> {
    ArrayDeque<String> stackIterators;
    int index = 0;

    public StackIterator() {
        this.stackIterators = new ArrayDeque<>();
    }

    public void push(String digit) {
        this.stackIterators.push(digit);
    }

    public void pop() {
        if (this.stackIterators.isEmpty()) {
            System.out.println("No elements");
            return;
        }
        this.stackIterators.pop();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private ArrayDeque<String> temp = new ArrayDeque<>(stackIterators);

            @Override
            public boolean hasNext() {
                return !temp.isEmpty();
            }

            @Override
            public String next() {
                return temp.pop();
            }
        };
    }
}
