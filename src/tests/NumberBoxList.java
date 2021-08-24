package tests;

import model.NumberBox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class NumberBoxList implements NumberBox {

    List<Integer> numbers;

    public NumberBoxList() {
        numbers = new ArrayList<>();
    }

    public NumberBoxList(int... numbers) { // можно использовать только один массив раз и только последним аргументом
        this();
        for (int i = 0; i < numbers.length; i++) {
            this.numbers.add(numbers[i]);
        }
    }

    @Override
    public void addNumber(int number) {
        numbers.add(number);
    }

    @Override
    public boolean removeNumber(int number) {
        return numbers.remove((Integer) number);
    }

    @Override
    public NumberBox getNumberByPredicate(Predicate<Integer> filter) {
        NumberBox nb = new NumberBoxList();
        for (Integer in : numbers) {
            if (filter.test(in)){
                nb.addNumber(in);
            }
        }
        return nb;
    }


    @Override
    public void removeRepeated() {
        Integer[] integers = numbers.toArray(new Integer[0]);
        for (Integer i : integers) {
            if (numbers.indexOf(i) != numbers.lastIndexOf(i)) {
                numbers.remove(numbers.lastIndexOf(i));
            }
        }

//        Object[] st = lst.toArray();
//        for (Object s : st) {
//            if (lst.indexOf(s) != lst.lastIndexOf(s)) {
//                lst.remove(lst.lastIndexOf(s));
//            }
//        }
    }

    @Override
    public void union(NumberBox nb) {

    }

    @Override
    public void subtract(NumberBox nb) {

    }

    @Override
    public void intersection(NumberBox nd) {

    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
