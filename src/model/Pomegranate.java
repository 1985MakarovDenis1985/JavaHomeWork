package model;

import controller.PomegranateApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Pomegranate implements Iterable {
    List<Seed> seeds = new ArrayList<>();

    public Pomegranate() {
        int randomN = Box.randomNum(10, 15);
        for (int i = 0; i < randomN; i++) {
            seeds.add(new Seed());
        }
    }

    public List<Seed> getSeeds() {
        return seeds;
    }


    @Override
    public Iterator iterator() {
        return iterator();
    }

    @Override
    public String toString() {
        return
                seeds.size() + " ";
    }
}
