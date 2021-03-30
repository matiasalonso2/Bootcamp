package JavaClase4TM;

import java.util.Comparator;

public class ComparatorIntAsc implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a-b;
    }
}
