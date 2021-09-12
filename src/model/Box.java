package model;

import controller.App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Box implements Iterable {
    String name;
    List<Pomegranate> granates = new ArrayList<>();

    public Box(String name) {
        int randomN = App.randomNum(10, 20);
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

    @Override
    public Iterator iterator() {
        return this.iterator();
    }
}
