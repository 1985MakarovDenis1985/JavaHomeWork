package controller;

import model.Box;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        // FIRST SOLUTION
        int randomN = Box.randomNum(5, 10);
        Map<Integer, ArrayList<Box>> mapOfBoxes = new HashMap<>();

        for (int i = 0; i < randomN; i++) {
            Box b = new Box("box_" + i);
            int newKey = b.getGranates()
                    .stream()
                    .mapToInt(el -> el.getSeeds().size()).sum();
            if (!mapOfBoxes.containsKey(newKey)) {
                mapOfBoxes.put(newKey, new ArrayList<>());
                mapOfBoxes.get(newKey).add(b);
            } else {
                mapOfBoxes.get(newKey).add(b);
            }
        }

        int getMaxSeedInTheBox = mapOfBoxes.entrySet().stream()
                .map(e -> e.getKey())
                .peek(System.out::println)
                .max(Integer::compareTo).orElse(0);
//        System.out.println("max seed in box: " + getMaxSeedInTheBox);

        int sumOfSeeds = mapOfBoxes.entrySet().stream()
                .mapToInt(e -> e.getKey()).sum();
//        System.out.println("sum of seeds " + sumOfSeeds);

        mapOfBoxes.get(getMaxSeedInTheBox).stream()
                .forEach(e -> System.out.println(e.getName()));


    }
}
