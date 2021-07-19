import java.util.Arrays;
import java.util.Scanner;

public class RangeApp {
    public static void main(String[] args) {
        runConsoleSession();
    }

    private static void runConsoleSession() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задайте начало диапазона:");
        double from = scanner.nextDouble();

        System.out.println("Задайте конец диапазона:");
        double to = scanner.nextDouble();

        Range range1 = new Range(from, to);

        System.out.println("Размер диапазона равен " + range1.getLength());

        System.out.println("Задайте любое число:");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.println("Число входит в диапазон");
        } else {
            System.out.println("Число не входит в диапазон");
        }

        System.out.println("Задайте начало второго диапазона:");
        from = scanner.nextDouble();

        System.out.println("Задайте конец второго диапазона:");
        to = scanner.nextDouble();

        Range range2 = new Range(from, to);

        if (range1.isCommonPointsExist(range2)) {
            System.out.println("У диапазонов есть общие точки");
        } else {
            System.out.println("У диапазонов нет общих точек");
        }

        Range intersectedRange = range1.getIntersectedRange(range2);

        if (intersectedRange != null) {
            System.out.println("Новый диапазон как пересечение диапазонов - " + intersectedRange);
        } else {
            System.out.println("Нет пересечения диапазонов");
        }

        System.out.println("Объединение диапазонов: " + Arrays.toString(range1.getUnion(range2)));
        System.out.println("Разность диапазонов: " + Arrays.toString(range1.getDifference(range2)));
    }
}