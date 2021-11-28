package sort.bubble;

import sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sort {

    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        List<T> result = new ArrayList<>(list);

        for (int i = 0; i < result.size(); i++) {
            T currentItem = result.get(i);

            for (int j = i + 1; j < result.size(); j++) {
                T checkedItem = result.get(j);

                if(currentItem.compareTo(checkedItem) > 0) {
                    result.set(i, checkedItem);
                    result.set(j, currentItem);
                    currentItem = checkedItem;
                }
            }
        }
        return result;
    }
}
