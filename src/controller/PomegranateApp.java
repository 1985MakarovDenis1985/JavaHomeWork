package controller;

import model.Box;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PomegranateApp {
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        int randomN = Box.randomNum(5, 10);

        for (int i = 0; i < randomN; i++) {
            boxes.add(new Box("box_" + i));
        }
//        for (int i = 0; i < boxes.size(); i++) {
//            System.out.println("box_" + i + " : granads - " + boxes.get(i).getGranates().size());
//            for (int j = 0; j < boxes.get(i).getGranates().size(); j++) {
//                System.out.print("granads_" + j + " seeds: " + boxes.get(i).getGranates().get(j).getSeeds().size() + " | ");
//            }
//            System.out.println();
//        }

//        int sumAllSeeds = getAllSeeds(boxes);
//        System.out.println("all seeds : " + sumAllSeeds);

        int maxSeedInTheBox = getMaxSeedInTheBox(boxes);
        System.out.println("max seeds in one box: " + maxSeedInTheBox);

        Map<Integer, List<Box>> mapOfBoxes = boxes.stream()
                .collect(Collectors.groupingBy(e -> e.getGranates()
                        .stream()
                        .mapToInt(el -> el.getSeeds().size()).sum())
                );

        System.out.println("--------- keys -----------");
        System.out.println("max box : " + mapOfBoxes.get(maxSeedInTheBox).size());

        mapOfBoxes.get(maxSeedInTheBox).stream()
                .forEach(e -> System.out.println(e.getName()));

        System.out.println(mapOfBoxes);

    }

    public static int getAllSeeds(List<Box> boxes) {
        return boxes.stream()
                .map(e -> e.getGranates().stream().map(t -> t.getSeeds().size()).reduce((a, b) -> a + b).orElse(0))
                .mapToInt(e -> e.intValue()).sum();
    }

    public static int getMaxSeedInTheBox(List<Box> boxes) {
       return boxes.stream()
               .map(e -> e.getGranates().stream()
                       .map(t -> t.getSeeds().size())
                       .reduce((a, b) -> a + b)
                       .orElse(0))

               .peek(e -> System.out.println(e))
               .max(Integer::compareTo).orElse(0);
    }

}
