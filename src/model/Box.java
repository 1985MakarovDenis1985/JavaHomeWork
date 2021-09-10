package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Box implements Iterable {
    String name;
    List<Pomegranate> granates = new ArrayList<>();

    public Box(String name) {
        int randomN = randomNum(2, 3);
        for (int i = 0; i < randomN; i++) {
            granates.add(new Pomegranate());
        }
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public List<Pomegranate> getGranates() {
        return granates;
    }

    public static int randomNum(int from, int to) {
        int min = from;
        int max = to;
        int diff = max - min;
        int i = new Random().nextInt(diff + 1);
        return i += min;
    }

    @Override
    public Iterator iterator() {
        return iterator();
    }

    @Override
    public String toString() {
        return name + " " +
                granates;
    }
}
