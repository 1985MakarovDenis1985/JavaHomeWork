package telran.point.dao;

import telran.point.comparators.PointComparator;
import telran.point.model.Point;

import java.util.Arrays;
import java.util.Comparator;

public class PointSpace {
    Point[] points;
    Point relPoint;
    Comparator<Point> comp;


    public PointSpace(Point[] points, Point relPoint) {
        this.points = points;
        this.relPoint = relPoint;
        comp = new PointComparator(relPoint);
        Arrays.sort(points, comp);

        // TODO
        //  сортировать this.points по расстоянию до relPoint
        //  применять Arrays.sort (массив отсортирован по расстоянию от главной точки)
    }

    public Point[] getPoints() {
        return points;
    }


    public void addPoint(Point point) {
        int index = Arrays.binarySearch(points, point, comp);
        index = index >= 0 ? index : -index - 1;

        Point[] res = new Point[points.length+1];
        System.arraycopy(points, 0, res, 0, index);
        System.arraycopy(points, index, res, index + 1, points.length - index);
        res[index] = point;
        points = res;

        // TODO
        //  применить метод бинарного поиска
        //  применить метод arrayCopy класса System
        // arrayCopy должен быть вызван дважды - намек!!!
    }
}
