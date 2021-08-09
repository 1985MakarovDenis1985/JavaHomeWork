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
        String[] a = {"55-02-1999", "34-14-3720", "55-03-1999", "33-02-1999", "12-33-2120", "67-08-2120", "12-12-2018", "75-55-2120", "09-05-2720", "21-02-1999", "21-08-3120"};
        String[] dates = {"12-04-1999", "05-03-1999", "30-10-1970", "10-10-2018"};
        String[] expected = {"10-10-1970", "12-03-1999", "05-04-1999", "10-10-2018"};

        Arrays.sort(a, new IComparator());
        printArray(a);

    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}

class IComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o11 = o1.split("-");
        String[] o22 = o2.split("-");

        //============= first solution================//

        int res = Integer.compare(Integer.parseInt(o11[2]), Integer.parseInt(o22[2])); // возвращает 1, 0, -1
        if (res == 0) {
            res = Integer.compare(Integer.parseInt(o11[1]), Integer.parseInt(o22[1]));
            if (res == 0) {
                return Integer.compare(Integer.parseInt(o11[0]), Integer.parseInt(o22[0]));
            }
            return res;
        }
        return res;

        //============= second solution================//

//        if (Integer.parseInt(o11[2]) > Integer.parseInt(o22[2])) {
//            return 1;
//        }
//        if (Integer.parseInt(o11[2]) == Integer.parseInt(o22[2])) {
//            if (Integer.parseInt(o11[1]) > Integer.parseInt(o22[1])) {
//                return 1;
//            } else if (Integer.parseInt(o11[1]) == Integer.parseInt(o22[1])) {
//                if (Integer.parseInt(o11[0]) > Integer.parseInt(o22[0])) {
//                    return 1;
//                }
//                return -1;
//            }
//        }
//        return 0;
    }
}
