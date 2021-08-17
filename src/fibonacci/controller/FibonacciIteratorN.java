//package fibonacci.controller;
//
//import java.util.Iterator;
//
//public class FibonacciIteratorN implements Iterator<Integer> {
//    private int current = 0;
//    private int a = 1;
//    private int b = 1;
//
//    @Override
//    public boolean hasNext() {
//        return current < quantity;
//    }
//
//    @Override
//    public Integer next() {
//        current++;
//        int value = a + b;
//        a = b;
//        b = value;
//        return value;
//    }
//}
