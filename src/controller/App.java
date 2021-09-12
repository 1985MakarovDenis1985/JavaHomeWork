package controller;

import model.Box;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class App {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        int randomN = randomNum(100, 200);

        for (int i = 0; i < randomN; i++) {
            boxes.add(new Box("box:" + i));
        }

        int sumAllSeeds = getAllSeeds(boxes);
        System.out.println("all seeds : " + sumAllSeeds);

        int maxSeedInTheBox = getMaxSeedInTheBox(boxes);
        System.out.println("max seeds in one box: " + maxSeedInTheBox);
        getAllBoxesWithMaxSeeds(boxes, maxSeedInTheBox);

    }

    private static int getAllSeeds(List<Box> boxes) {
        return boxes.stream()
                .map(e -> e.getGranates().stream().map(t -> t.getSeeds().size()).reduce((a, b) -> a + b).orElse(0))
                .mapToInt(e -> e.intValue()).sum();
    }

    private static int getMaxSeedInTheBox(List<Box> boxes) {
        return boxes.stream()
                .map(e -> e.getGranates().stream().map(t -> t.getSeeds().size()).reduce((a, b) -> a + b).orElse(0))
                .max(Integer::compareTo).orElse(0);
    }

    private static void getAllBoxesWithMaxSeeds(List<Box> boxes, int max){
        Map<Integer, List<Box>> getNames = boxes.stream()
                .collect(Collectors.groupingBy(p -> p.getGranates().stream().mapToInt(e -> e.getSeeds().size()).sum()));

        Iterable<String> str = getNames.get(max).stream()
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
