package dateOperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateOperationTest extends DateOperation {
    @Test
    void testSortStringDates() {
        String[] dates = {
                "2001-12-01", "10/12/2002", "1970-08-12", "2010-10-05"
        };
        String[] expected = {
                "1970-08-12", "2001-12-01", "10/12/2002", "2010-10-05"
        };
        assertArrayEquals(expected, DateOperation.sortStringDates(dates));
    }

    @Test
    void testGetAge() {
        assertEquals(60, DateOperation.getAge("12/04/1961"));
        assertEquals(59, DateOperation.getAge("1961-10-12"));
    }


}