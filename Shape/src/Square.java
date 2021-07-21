public class Square extends Rectangle {
    public Square(Point startPoint, double sideLength, double angle) {
        super(startPoint, sideLength, sideLength, angle);
    }

    @Override
    public String toString() {
        return "Square{" +
                "angle=" + getAngle() +
                ", firstSideLength=" + getFirstSideLength() +
                ", secondSideLength=" + getSecondSideLength() +
                ", startPoint=" + getStartPoint() +
                ", secondPoint=" + getSecondPoint() +
                ", thirdPoint=" + getThirdPoint() +
                ", fourthPoint=" + getFourthPoint() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}