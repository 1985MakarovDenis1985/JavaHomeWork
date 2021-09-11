package controller;

import model.Box;

import java.util.*;

//public class PomegranateApp {
//    public static void main(String[] args) {
//        List<Box> boxes = new ArrayList<>();               // arrList with random boxes
//        List<Integer> indexOfMaxBox = new ArrayList<>();   // arrList with indexes box with max seeds
//        int randomN = Box.randomNum(10, 17);
//        int maxValue = 0;                                  // maxValue in box
//
//        for (int i = 0; i < randomN; i++) {
//            Box b = new Box("box_" + i);
//            int num = b.getGranates().stream().mapToInt(e -> e.getSeeds().size()).sum(); // count max seeds in the new box
//            if (maxValue < num) {
//                maxValue = num;
//                indexOfMaxBox.clear(); // if find new max -> cleaning arr with index max seeds box
//                indexOfMaxBox.add(i);  // add new value
//            } else if (maxValue == num) {
//                indexOfMaxBox.add(i); // if find else the same max seeds -> add in to arr with indexes of boxes
//            }
//            boxes.add(b);
//        }
//
//        int sumAllSeeds = getAllSeeds(boxes);
//        System.out.println("all seeds : " + sumAllSeeds);
//
////        int maxSeedInTheBox = getMaxSeedInTheBox(boxes);
//        System.out.println("max seeds in one box: " + maxValue);
//
//        getBoxesWithMaxSeeds(boxes, indexOfMaxBox);
//
//    }
//
//    public static int getAllSeeds(List<Box> boxes) {
//        return boxes.stream()
//                .map(e -> e.getGranates().stream()
//                        .map(t -> t.getSeeds().size())
//                        .reduce((a, b) -> a + b)
//                        .orElse(0))
//                .mapToInt(e -> e.intValue()).sum();
//    }
//
//    public static int getMaxSeedInTheBox(List<Box> boxes) { // not using
//        return boxes.stream()
//                .map(e -> e.getGranates().stream()
//                        .map(t -> t.getSeeds().size())
//                        .reduce((a, b) -> a + b)
//                        .orElse(0))
//                .max(Integer::compareTo).orElse(0);
//    }
//
//    public static void getBoxesWithMaxSeeds(List<Box> boxes, List<Integer> index) {
//        for (int i = 0; i < index.size(); i++) {
//            System.out.println(boxes.get(index.get(i)).getName());
//        }
//    }
//
//}

// ==========================================================================

//
public class PomegranateApp {
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        int randomN = Box.randomNum(5, 10);
        Map<Integer, ArrayList<Box>> mapOfBoxes = new HashMap<>();


        for (int i = 0; i < randomN; i++) {
//            boxes.add(new Box("box_" + i));

            Box b = new Box("box_" + i);
            int a = b.getGranates()
                    .stream()
                    .mapToInt(el -> el.getSeeds().size()).sum();
            if (!mapOfBoxes.containsKey(a)){
                mapOfBoxes.put(a, new ArrayList<>());
            } else {
                mapOfBoxes.get(a).add(b);
            }


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

//        int maxSeedInTheBox = getMaxSeedInTheBox(boxes);
//        System.out.println("max seeds in one box: " + maxSeedInTheBox);

//        Map<Integer, List<Box>> mapOfBoxes = boxes.stream()
//                .collect(Collectors.groupingBy(e -> e.getGranates()
//                        .stream()
//                        .mapToInt(el -> el.getSeeds().size()).sum())
//                );
//
//        System.out.println(mapOfBoxes);


//        System.out.println("--------- keys -----------");
//        System.out.println("max box : " + mapOfBoxes.get(maxSeedInTheBox).size());

//        mapOfBoxes.get(maxSeedInTheBox).stream()
//                .forEach(e -> System.out.println(e.getName()));

//        System.out.println(mapOfBoxes);

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