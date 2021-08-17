package fibonacci.model;

import java.util.Iterator;

public class Fibonacci implements Iterable<Integer> {
    private int quantity;

    public Fibonacci(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIteratorN();
    }


    private class FibonacciIteratorN implements Iterator<Integer> {
        private int current = 0;
        private int a = 1;
        private int b = 0;

        @Override
        public boolean hasNext() {
            return current < quantity;
        }

        @Override
        public Integer next() {
            current++;
            int value = a + b;
            a = b;
            b = value;
            return value;
        }
    }

}
