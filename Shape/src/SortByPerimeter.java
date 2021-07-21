import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.getPerimeter(), o2.getPerimeter());
    }
}