import java.util.Arrays;
import java.util.Comparator;

public class ShapeApp {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];

        shapes[0] = new Circle(new Point(1, 1), 20);
        shapes[1] = new Circle(new Point(1, 1), 5);
        shapes[2] = new Circle(new Point(1, 1), 7);
        shapes[3] = Rectangle.RectangleBuilder.aRectangle().angle(45).firstSideLength(100).secondSideLength(100).startPoint(0, 0).build();
        shapes[4] = Rectangle.RectangleBuilder.aRectangle().angle(30).firstSideLength(6.8).secondSideLength(9).startPoint(30, 30).build();
        shapes[5] = new Triangle(1, 1, 20, 1, 30, 30);
        shapes[6] = new Triangle(1, 10, 20, 10, 30, 300);
        shapes[7] = new Triangle(1, 0, 5, 1, 6, 6);
        shapes[8] = new Square(new Point(6, 6), 7, 0);
        shapes[9] = new Square(new Point(6, 6), 4, 30);

        System.out.println("Фигура с максимальным периметром:");
        System.out.println(getMaxPerimeterShape(shapes));
        System.out.println();

        System.out.println("Фигура с максимальной площадью:");
        System.out.println(getMaxAreaShape(shapes));
        System.out.println();

        Shape maxPerimeterShape = Arrays.stream(shapes).max(Comparator.comparingDouble(Shape::getPerimeter)).orElse(null);
        System.out.println("Фигура с максимальным периметром через Stream API:");
        System.out.println(maxPerimeterShape);
        System.out.println();

        Shape maxAreaShape = Arrays.stream(shapes).max(Comparator.comparingDouble(Shape::getArea)).orElse(null);
        System.out.println("Фигура с максимальной площадью через Stream API:");
        System.out.println(maxAreaShape);
        System.out.println();

        Triangle triangle1 = new Triangle(1, 1, 2, 0, 0, 10);
        System.out.println("Первый треугольник - " + triangle1);
        System.out.println();

        Triangle triangle2 = new Triangle(2, 0, 1, 1, 0, 10);
        System.out.println("Второй треугольник - " + triangle2);
        System.out.println();

        System.out.println("Результаты сравнения треугольников:");
        System.out.println("triangle1.equals(triangle2) = " + triangle1.equals(triangle2));
        System.out.println("triangle2.equals(triangle1) = " + triangle2.equals(triangle1));
        System.out.println();

        Square square1 = new Square(new Point(0, 0), 3, 0);
        System.out.println("Вершины первого квадрата:");
        square1.printVertexes();
        System.out.println();

        Square square2 = new Square(new Point(3, 0), 3, 90);
        System.out.println("Вершины второго квадрата:");
        square2.printVertexes();
        System.out.println();

        System.out.println("Результаты сравнения квадратов:");
        System.out.println("square1.equals(square2) = " + square1.equals(square2));
        System.out.println("square2.equals(square1) = " + square2.equals(square1));
    }

    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new SortByArea());
        return shapes[shapes.length - 1];
    }

    public static Shape getMaxPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, new SortByPerimeter());
        return shapes[shapes.length - 1];
    }
}