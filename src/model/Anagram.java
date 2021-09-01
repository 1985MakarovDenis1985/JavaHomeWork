package model;
import java.util.*;

public class Anagram {
    private static void margeInHashMap(String[] arr, Map<String, Integer> res) {
        for (int i = 0; i < arr.length; i++) {
            String newValue = arr[i].toLowerCase();
            res.merge(newValue, 1, (oldValue, value) -> oldValue + 1);
        }
    }

    public static boolean isAnagram(String w1, String w2) {
        if (w2 == null || w1 == null) {
            return false;
        }
        Map<String, Integer> wordFirst = new HashMap<>();
        Map<String, Integer> wordSecond = new HashMap<>();

        margeInHashMap(w1.split(""), wordFirst);
        margeInHashMap(w2.split(""), wordSecond);

        Iterator it = wordSecond.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (!(wordFirst.containsKey(pair.getKey()) && (int) pair.getValue() <= wordFirst.get(pair.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
