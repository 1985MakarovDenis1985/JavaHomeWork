package model;

//public class Anagram {
//    public static boolean isAnagram(String w1, String w2){
//
//        String a = new String(w1);
//        String b = new String(w2);
//
//        return false;
//    }
//}


import java.util.*;

class App {
    public static boolean isAnagram(String w1, String w2) {

        String[] c = w1.split("");
        String[] v = w2.split("");
        Map<String, Integer> res = new HashMap<>();
        Map<String, Integer> res2 = new HashMap<>();
        boolean isTrue = true;

        for (int i = 0; i < c.length; i++) {
            String newValue = c[i].toLowerCase();
            res.merge(newValue, 1, (oldValue, value) -> oldValue + 1);
        }
        for (int i = 0; i < v.length; i++) {
            String newValue = v[i].toLowerCase();
            res2.merge(newValue, 1, (oldValue, value) -> oldValue + 1);
        }

        Iterator it = res2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
//            System.out.println(pair.getKey());
//            System.out.println(pair.getValue());

//            System.out.println("r : " + res.get(pair.getKey()));
//            System.out.println("p : " + pair.getValue());
            if (!(res.containsKey(pair.getKey()) && (int) pair.getValue() <= res.get(pair.getKey()))) {
                isTrue = false;
            }
//            else {
//                isTrue =  false;
//            }
        }
        return isTrue;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("EhlohheLE", "ELLhhHeE"));

//        isAnagram("EhlohheLE", "Ehlheee");
    }
}