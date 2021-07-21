import java.util.HashSet;
import java.util.Set;
import java.util.stream.DoubleStream;

public class Triangle implements Shape {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        firstPoint = new Point(x1, y1);
        secondPoint = new Point(x2, y2);
        thirdPoint = new Point(x3, y3);
    }

    @Override
    public double getWidth() {
        double maxX = DoubleStream.of(firstPoint.getX(), secondPoint.getX(), thirdPoint.getX()).max().orElseThrow(() -> new ShapeException("Неверные координаты треугольника"));
        double minX = DoubleStream.of(firstPoint.getX(), secondPoint.getX(), thirdPoint.getX()).min().orElseThrow(() -> new ShapeException("Неверные координаты треугольника"));
        return maxX - minX;
    }

    @Override
    public double getHeight() {
        double maxY = DoubleStream.of(firstPoint.getY(), secondPoint.getY(), thirdPoint.getY()).max().orElseThrow(() -> new ShapeException("Неверные координаты треугольника"));
        double minY = DoubleStream.of(firstPoint.getY(), secondPoint.getY(), thirdPoint.getY()).min().orElseThrow(() -> new ShapeException("Неверные координаты треугольника"));
        return maxY - minY;
    }

    @Override
    public double getArea() {
        return getHeight() * getWidth() / 2;
    }

    @Override
    public double getPerimeter() {
        return firstPoint.getDistance(secondPoint) + firstPoint.getDistance(thirdPoint) + secondPoint.getDistance(thirdPoint);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    @Override
    public int hashCode() {
        int result = firstPoint.hashCode();
        result = 31 * result + secondPoint.hashCode();
        result = 31 * result + thirdPoint.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Triangle)) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        Set<Point> thisTrianglePoints = new HashSet<>();

        thisTrianglePoints.add(this.firstPoint);
        thisTrianglePoints.add(this.secondPoint);
        thisTrianglePoints.add(this.thirdPoint);

        Set<Point> oTrianglePoints = new HashSet<>();

        oTrianglePoints.add(triangle.getFirstPoint());
        oTrianglePoints.add(triangle.getSecondPoint());
        oTrianglePoints.add(triangle.getThirdPoint());

        return thisTrianglePoints.equals(oTrianglePoints);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }
}