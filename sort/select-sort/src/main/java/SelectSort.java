import sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class SelectSort implements Sort {

    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        List<T> sorted = new ArrayList<>(list.size());
        ArrayList<T> unsorted = new ArrayList<>(list);

        while(!unsorted.isEmpty()) {
            T smallestUnsorted = unsorted.stream().reduce((acc, item) -> {
                if (acc.compareTo(item) > 0) {
                    acc = item;
                }
                return acc;
            }).get();

            sorted.add(smallestUnsorted);
            unsorted.remove(smallestUnsorted);
        }

        return sorted;
    }
}
