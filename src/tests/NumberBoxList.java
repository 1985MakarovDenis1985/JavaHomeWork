package tests;

import model.NumberBox;

import java.util.ArrayList;
import java.util.Collection;
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
            if (filter.test(in)) {
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
    }

    @Override
    public void union(NumberBox nb) {
        for (Integer i : nb) {
            if (!numbers.contains(i)) {
                numbers.add(i);
            }
        }
    }

    @Override
    public void intersection(NumberBox nb) {
        Integer[] a = numbers.toArray(new Integer[0]);
        ArrayList<Integer> temp = new ArrayList<>();

        int count = 0;
        for (Integer i : nb) {
            if (i.equals(a[count])) {
                temp.add(i);
            }
            count++;
        }
        numbers = temp;
    }


    @Override
    public void subtract(NumberBox nb) {
        for (Integer i : nb) {
            if (numbers.contains(i)) {
                for (int j = 0; j < numbers.size(); j++) {
                    numbers.remove(i);
                }
            }
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
