import sort.Sort;

import java.util.LinkedList;
import java.util.List;

public class InsertSort implements Sort {

    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        LinkedList<T> sorted = new LinkedList<>();

        list.forEach(item -> {
            if (sorted.size() == 0) {
                sorted.add(item);
            } else {
                int i = 0;
                for (; i < sorted.size(); i++) {
                    if (sorted.get(i).compareTo(item) > 0) {
                        break;
                    }
                }
                sorted.add(i, item);
            }
        });

        return sorted;
    }
}
