package oddEvenComparator.tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void testDate() {
        String[] dates = {"12-03-1999", "05-04-1999", "10-10-1970", "10-10-2018"};
        String[] expected = {"10-10-1970", "12-03-1999", "05-04-1999", "10-10-2018"};

        Arrays.sort(dates, (d1, d2) -> {
                String[] d1Separated = d1.split("-");
                String[] d2Separated = d2.split("-");
            int res = Integer.compare(Integer.parseInt(d1Separated[2]), Integer.parseInt(d2Separated[2])); // возвращает 1, 0, -1
            if (res == 0) {
                res = Integer.compare(Integer.parseInt(d1Separated[1]), Integer.parseInt(d2Separated[1]));
                if (res == 0) {
                    return Integer.compare(Integer.parseInt(d1Separated[0]), Integer.parseInt(d2Separated[0]));
                }
                return res;
            }
            return res;
        });
        assertArrayEquals(expected, dates);
    }
}