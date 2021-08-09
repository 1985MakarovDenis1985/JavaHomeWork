package oddEvenComparator.tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenComparatorTest {
    Integer[] origin = {1, 2, 3, 6, 5, 4, 7, 8, 9, 3};
    Integer[] expected = {2, 4, 6, 8, 9, 7, 5, 3, 3, 1};

    @Test
    void testInteger() {
        Arrays.sort(origin, (a, b) -> {
            if (a % 2 == 1 && b % 2 == 0) {
                return 1;
            }
            if (a % 2 == 0 && b % 2 == 1) {
                return -1;
            }
            if (a % 2 == 0 && b % 2 == 0) {
                return a.compareTo(b);
            }
            if (a % 2 == 1 && b % 2 == 1) {
                return -a.compareTo(b);
            } else {
                return 0;
            }
        });
        assertArrayEquals(expected, origin);
    }

    @Test
    void testString() {
        String[] dates = {"12-203-1999", "05-304-1999", "30-110-1970", "10-410-2018"};
        String[] expected = {"10-10-1970", "12-03-1999", "05-04-1999", "10-10-2018"};


        Comparator<String> comp = (a, b) -> {
            String[] aa = a.split("-");
            String[] bb = b.split("-");

            if (Integer.parseInt(aa[2]) > Integer.parseInt(bb[2])) {
                return 1;
            }

            return a.compareTo(b);
        };


        Arrays.sort(dates);
        System.out.println("============");
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }

//        assertArrayEquals(expected, origin);
    }
}