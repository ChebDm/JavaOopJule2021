/**
 * Point class is a simple class that describes the position of an arbitrary point in a two-dimensional coordinate system.
 * The fields of the class are the x and y coordinates.
 */
public class Point {
    final static double EPSILON = 1.0E-05;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double angle, double x, double y) {
        double angleSin = Math.sin(Math.toRadians(angle));
        double angleCos = Math.cos(Math.toRadians(angle));
        this.x = x * angleCos - y * angleSin;
        this.y = x * angleSin + y * angleCos;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX() - (int) getX() > EPSILON ? getX() : (int) getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY() - (int) getY() > EPSILON ? getY() : (int) getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }

        Point point = (Point) o;

        if (Math.abs(point.getX() - getX()) > EPSILON) {
            return false;
        }
        return Math.abs(point.getY() - getY()) <= EPSILON;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistance(Point anotherPoint) {
        return Math.sqrt(Math.pow((x - anotherPoint.x), 2) + Math.pow((y - anotherPoint.y), 2));
    }
}