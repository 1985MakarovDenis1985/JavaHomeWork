package oddEvenComparator;

import java.util.Arrays;
import java.util.Comparator;

public class OddEvenComparator {

    public static void main(String[] args) {
//        Integer[] origin = {1, 2, 3, 6, 5, 4, 7, 8, 9, 3};
//        Integer[] expected = {2, 4, 6, 8, 9, 7, 5, 3, 3, 1};
//
//        Arrays.sort(origin, (a, b) -> {
//            if (a % 2 == 1 && b % 2 == 0) {
//                return 1;
//            }
//            if (a % 2 == 0 && b % 2 == 1) {
//                return -1;
//            }
//            if (a % 2 == 0 && b % 2 == 0 ) {
//                return a.compareTo(b);
//            }
//            if (a % 2 == 1 && b % 2 == 1) {
//                return -a.compareTo(b);
//            } else{
//                return 0;
//            }
//
//        });
//        printArray(origin);
        String[] a = {"4-2420", "3-2120","2-2018", "3-2120","5-2720", "1-1999","6-3120"};
        String[] dates = {"12-203-1999", "05-304-1999", "30-110-1970", "10-410-2018"};
        String[] expected = {"10-10-1970", "12-03-1999", "05-04-1999", "10-10-2018"};

        Arrays.sort(a, new IComparator());
        printArray(a);

    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class IComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o11 = o1.split("-");
        String[] o22 = o2.split("-");

        if (Integer.parseInt(o11[1]) == Integer.parseInt(o22[1])){
            return 0;
        }
        if (Integer.parseInt(o11[1]) < Integer.parseInt(o22[1])){
            return -1;
        }
        return 1;
    }
}
