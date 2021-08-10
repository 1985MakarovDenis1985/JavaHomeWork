package telran.point.comparators;

import telran.point.model.Point;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    Point relPoint; // точка отсчета;

    public PointComparator(Point relPoint) {
        this.relPoint = relPoint;
    }

    @Override
    public int compare(Point p1, Point p2) {
        // TODO
        //  go to google and ask of Pithagoras
        double res_1 = Math.sqrt(Math.pow((p1.getX() - relPoint.getX()), 2) + Math.pow((p1.getY() - relPoint.getY()), 2));
        double res_2 = Math.sqrt(Math.pow((p2.getX() - relPoint.getX()), 2) + Math.pow((p2.getY() - relPoint.getY()), 2));
        return Double.compare(res_1, res_2);
    }

}
