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

        String a = new String(w1);
        String b = new String(w2);
//        char[] q = w1.toCharArray();
//        for (int i = 0; i < q.length; i++) {
//            System.out.println(q[i]);
//        }
//
//        ArrayList<Character> charListW1 = new ArrayList<Character>();
//        ArrayList<Character> charListW2 = new ArrayList<Character>();
//
//        for (char c : w1.toLowerCase().toCharArray()) {
//            charListW1.add(c);
//        }
//        for (char c : w1.toLowerCase().toCharArray()) {
//            charListW2.add(c);
//        }
//
//        for (char c : charListW1) {
//            if (charListW2.contains(c)){
//                System.out.println(true);
//                charListW1.remove(c);
//            } else {
//                System.out.println(false);
//
//            }
//        }
        String[] c = a.split("");
        String[] v = b.split("");
        Map<String, Integer> res = new HashMap<>();
        Map<String, Integer> res2 = new HashMap<>();

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
            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey());
//            System.out.println(pair.getValue());

//            System.out.println("r : " + res.get(pair.getKey()));
//            System.out.println("p : " + pair.getValue());


            int t = res.get(pair.getKey());
            int tt = (int) pair.getValue();

            System.out.println("t : " + t);
            System.out.println("tt : " + tt);



            if (res.containsKey(pair.getKey())){
//                System.out.println(true);
            }
            if (tt <= t){
                System.out.println(true);
            }
            else {
                System.out.println(false);
            }



//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
        }

//        System.out.println(res.get("e"));

//
//        Set<Map.Entry<String, Integer>> entries = res2.entrySet();
//        List<Map.Entry<Integer, Integer>> list = new ArrayList(entries);


//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        return false;
    }


    public static void main(String[] args) {

        isAnagram("EhlohheLE", "Ehlheeee");
    }
}