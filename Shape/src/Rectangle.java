import java.util.HashSet;
import java.util.Set;

/**
 * Class Rectangle - describes a rectangle in a two-dimensional coordinate system.
 * To define a rectangle on a plane, you need to specify the initial vertex,
 * the lengths of the sides of the rectangle and the angle of rotation of this shape relative to the coordinate axes.
 * It is considered that the rotation of the rectangle is carried out through its initial vertex.
 */
public class Rectangle implements Shape {
    private Point startPoint;
    private double firstSideLength;
    private double secondSideLength;
    private double angle;

    public Rectangle() {
    }

    public Rectangle(Point startPoint, double firstSideLength, double secondSideLength, double angle) {
        this.startPoint = startPoint;
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
        this.angle = angle;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getStartPoint().hashCode();
        temp = Double.doubleToLongBits(getFirstSideLength());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSecondSideLength());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAngle());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        Set<Point> thisRectanglePoints = new HashSet<>();

        thisRectanglePoints.add(this.startPoint);
        thisRectanglePoints.add(this.getSecondPoint());
        thisRectanglePoints.add(this.getThirdPoint());
        thisRectanglePoints.add(this.getFourthPoint());

        Set<Point> oRectanglePoints = new HashSet<>();

        oRectanglePoints.add(rectangle.getStartPoint());
        oRectanglePoints.add(rectangle.getSecondPoint());
        oRectanglePoints.add(rectangle.getThirdPoint());
        oRectanglePoints.add(rectangle.getFourthPoint());

        return thisRectanglePoints.equals(oRectanglePoints);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "angle=" + angle +
                ", firstSideLength=" + firstSideLength +
                ", secondSideLength=" + secondSideLength +
                ", startPoint=" + startPoint +
                ", secondPoint=" + getSecondPoint() +
                ", thirdPoint=" + getThirdPoint() +
                ", fourthPoint=" + getFourthPoint() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public double getFirstSideLength() {
        return firstSideLength;
    }

    public void setFirstSideLength(double firstSideLength) {
        this.firstSideLength = firstSideLength;
    }

    public double getSecondSideLength() {
        return secondSideLength;
    }

    public void setSecondSideLength(double secondSideLength) {
        this.secondSideLength = secondSideLength;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Point getSecondPoint() {
        Point point = new Point(angle, 0, firstSideLength);

        point.setX(point.getX() + startPoint.getX());
        point.setY(point.getY() + startPoint.getY());

        return point;
    }

    public Point getFourthPoint() {
        Point point = new Point(angle, secondSideLength, 0);

        point.setX(point.getX() + startPoint.getX());
        point.setY(point.getY() + startPoint.getY());

        return point;
    }

    public Point getThirdPoint() {
        Point point = new Point(angle, secondSideLength, firstSideLength);

        point.setX(point.getX() + startPoint.getX());
        point.setY(point.getY() + startPoint.getY());

        return point;
    }

    @Override
    public double getWidth() {
        return secondSideLength;
    }

    @Override
    public double getHeight() {
        return firstSideLength;
    }

    @Override
    public double getArea() {
        return firstSideLength * secondSideLength;
    }

    @Override
    public double getPerimeter() {
        return 2 * (firstSideLength + secondSideLength);
    }

    public void printVertexes() {
        System.out.println(startPoint);
        System.out.println(getSecondPoint());
        System.out.println(getThirdPoint());
        System.out.println(getFourthPoint());
    }

    public static final class RectangleBuilder {
        private Point startPoint;
        private double firstSideLength;
        private double secondSideLength;
        private double angle;

        RectangleBuilder() {
        }

        public static RectangleBuilder aRectangle() {
            return new RectangleBuilder();
        }

        public RectangleBuilder startPoint(Point startPoint) {
            this.startPoint = startPoint;
            return this;
        }

        public RectangleBuilder startPoint(double x, double y) {
            this.startPoint = new Point(x, y);

            return this;
        }

        public RectangleBuilder firstSideLength(double firstSideLength) {
            this.firstSideLength = firstSideLength;
            return this;
        }

        public RectangleBuilder secondSideLength(double secondSideLength) {
            this.secondSideLength = secondSideLength;
            return this;
        }

        public RectangleBuilder angle(double angle) {
            this.angle = angle;
            return this;
        }

        public Rectangle build() {
            return new Rectangle(startPoint, firstSideLength, secondSideLength, angle);
        }
    }
}