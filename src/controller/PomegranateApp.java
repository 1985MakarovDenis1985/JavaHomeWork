package controller;

import model.Box;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PomegranateApp {
    public static void main(String[] args) {

        int randomN = randomNum(100, 200);
        Map<Integer, ArrayList<Box>> mapOfBoxes = new HashMap<>();

        for (int i = 0; i < randomN; i++) {
            Box box = new Box("box_" + i);
            int newKey = box.getGranates().stream()
                    .mapToInt(el -> el.getSeeds().size())
                    .sum();
            if (!mapOfBoxes.containsKey(newKey)) mapOfBoxes.put(newKey, new ArrayList<>());
            mapOfBoxes.get(newKey).add(box);
        }

        int getMaxSeedInTheBox = mapOfBoxes.entrySet().stream()
                .map(e -> e.getKey())
                .max(Integer::compareTo).orElse(0);
        System.out.println("max seed in box: " + getMaxSeedInTheBox);

        int sumOfSeeds = mapOfBoxes.entrySet().stream()
                .mapToInt(e -> e.getKey()).sum();
        System.out.println("sum of seeds " + sumOfSeeds);

//  ------ names of boxes just ptint ------ //
//        mapOfBoxes.get(getMaxSeedInTheBox).stream()
//                .forEach(e -> System.out.println(e.getName()));

// ------ names of boxes in List with spliterator------//
        System.out.println("names of boxes with max seeds: ");
        Iterable<String> str = mapOfBoxes.get(getMaxSeedInTheBox).stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());
        StreamSupport.stream(str.spliterator(), false)
                .forEach(System.out::println);
    }

    public static int randomNum(int from, int to) {
        int min = from;
        int max = to;
        int diff = max - min;
        int i = new Random().nextInt(diff + 1);
        return i += min;
    }
}
