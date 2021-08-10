package telran.point.tests;
import org.junit.jupiter.api.Test;
import telran.point.dao.PointSpace;
import telran.point.model.Point;
import static org.junit.jupiter.api.Assertions.*;

class PointSpaceTest {

    Point p0 = new Point(0, 0);
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(3, 3);
    Point p4 = new Point(4, 4);
    Point p_2 = new Point(-2, -2);
    Point[] original = {p3, p2, p0, p4};
    Point[] expected0 = {p0, p2, p3, p4};
    Point[] expected4 = {p4, p3, p2, p0};
    Point[] expected01 = {p0, p1, p2, p3, p4};
    Point[] expected01_2 = {p0, p1, p_2, p2, p3, p4};

    @Test
    void testPointSpace() {
        PointSpace ps = new PointSpace(original, p0);
        assertArrayEquals(expected0, ps.getPoints());
        ps = new PointSpace(original, p4);
        assertArrayEquals (expected4, ps.getPoints());
    }

    @Test
    void testAddPoint() {
        PointSpace ps = new PointSpace(original, p0);
        ps.addPoint(p1);
        assertArrayEquals(expected01, ps.getPoints());
        ps.addPoint(p_2);
        assertArrayEquals(expected01_2, ps.getPoints());
    }
}