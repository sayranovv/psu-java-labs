package entities;

import java.util.*;

public class Polyline {

    private List<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public int getPointCount() {
        return points.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");

        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}