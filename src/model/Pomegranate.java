package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pomegranate implements Iterable {
    List<Seed> seeds = new ArrayList<>();

    public Pomegranate() {
        int randomN = Box.randomNum(400, 700);
        for (int i = 0; i < randomN; i++) {
            seeds.add(new Seed());
        }
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    @Override
    public Iterator iterator() {
        return this.iterator();
    }

}
