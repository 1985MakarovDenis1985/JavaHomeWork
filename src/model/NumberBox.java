package model;

import java.util.function.Predicate;

public interface NumberBox extends Iterable <Integer> {
    void addNumber(int number);
    boolean removeNumber(int number);
    NumberBox getNumberByPredicate(Predicate<Integer> filter);
    void removeRepeated();
    void union (NumberBox nb);
    void subtract (NumberBox nb);
    void intersection(NumberBox nd);
}
