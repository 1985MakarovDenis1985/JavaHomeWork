package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.NumberBoxList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberBoxTest extends NumberBoxList {
    NumberBox box;
    NumberBox nd;

    @BeforeEach
    void setUp() {
        box = new NumberBoxList(2, 2, 3, 3, 7, 5);
        nd = new NumberBoxList(2, 3, 3, 3, 4);
    }
    // ------------------------------------------------------------------------------------ //

    @Test
    void testAddNumber() {
        box.addNumber(4);
        checkBox(box, 2, 2, 3, 3, 4, 5, 7);
    }

    private void checkBox(NumberBox box, Integer... expected) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : box) {
            list.add(num);
        }
        Integer[] actual = list.toArray(new Integer[0]); // арумент нужен только, что бы понять какого типа аргумент (не важно какого газмера size - хоть size)
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    // ------------------------------------------------------------------------------------ //

    @Test
    void testRemoveNumber() {
        assertFalse(box.removeNumber(4));
        assertTrue(box.removeNumber(3));
        checkBox(box, 2, 2, 3, 5, 7);
    }

    // ------------------------------------------------------------------------------------ //

    @Test
    void testGetNumberByPredicate() {
        NumberBox res = box.getNumberByPredicate(x -> x % 2 == 0);
        checkBox(res, 2, 2);
    }

    // ------------------------------------------------------------------------------------ //

    @Test
    void testRemoveRepeated() {
        box.removeRepeated();
        checkBox(box, 2, 3, 5, 7);
    }

    // ------------------------------------------------------------------------------------ //

    @Test
    void testUnion() {
        box.union(nd);
        checkBox(box, 2, 2, 3, 4, 5, 7);
    }

    // ------------------------------------------------------------------------------------ //

    @Test
    void testIntersection() {  // одинакого по количеству ел
        box.intersection(nd);
        checkBox(box, 2, 3, 3);
    }

    // ------------------------------------------------------------------------------------ //

    @Test
    void testSubtract() {
        box.subtract(nd);
        checkBox(box,  5, 7);
    }
}