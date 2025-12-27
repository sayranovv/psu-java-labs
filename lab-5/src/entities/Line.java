package entities;

public class Line {
    private Point startPoint;

    private Point endPoint;

    public Line() {
        this.startPoint = new Point(0, 0);
        this.endPoint = new Point(0, 0);
    }

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }


    @Override
    public String toString() {
        return "Линия от " + startPoint.toString() + " до " + endPoint.toString();
    }
}