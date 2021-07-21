import java.util.StringJoiner;

public class Circle implements Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Circle)) {
            return false;
        }

        Circle circle = (Circle) o;

        if (Double.compare(circle.radius, radius) != 0) {
            return false;
        }
        return center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Circle.class.getSimpleName() + "[", "]")
                .add("area=" + getArea())
                .add("center=" + center)
                .add("height=" + getHeight())
                .add("perimeter=" + getPerimeter())
                .add("radius=" + radius)
                .add("width=" + getWidth())
                .toString();
    }

    @Override
    public double getWidth() {
        return radius;
    }

    @Override
    public double getHeight() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius / 2;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}