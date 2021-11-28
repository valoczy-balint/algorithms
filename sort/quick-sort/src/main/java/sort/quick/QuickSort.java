package sort.quick;

import org.jetbrains.annotations.NotNull;
import sort.Sort;

import java.util.*;

public class QuickSort implements Sort {

    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        return recursive(new LinkedList<>(list));
    }

    private <T extends Comparable<T>> List<T> recursive(List<T> list) {
        T pivot;

        if (list.size() < 2) {
            return list;
        } else if (list.size() == 2) {
            pivot = list.get(1);
        } else {
            pivot = getPivot(list);

        }

        LinkedList<T> partitioned = partition(list, pivot);

        List<T> left = recursive(partitioned.subList(0, partitioned.indexOf(pivot)));
        List<T> right = recursive(partitioned.subList(partitioned.indexOf(pivot) + 1, partitioned.size()));

        return collect(pivot, left, right);
    }

    // Side effect
    private <T extends Comparable> T getPivot(List<T> list) {
        T first = list.get(0);
        T last = list.get(list.size() - 1);
        T middle = list.get(list.size() / 2);

        LinkedList<T> sorted = new LinkedList<>();
        sorted.add(first);

        if (first.compareTo(middle) > 0) {
            sorted.addFirst(middle);
        } else {
            sorted.addLast(middle);
        }
        if(last.compareTo(sorted.getLast()) > 0) {
            sorted.addLast(last);
        } else if(sorted.getFirst().compareTo(last) > 0) {
            sorted.addFirst(last);
        } else {
            sorted.add(1, last);
        }

        list.set(0, sorted.get(0));
        T pivot = sorted.get(sorted.size() / 2);
        list.set(list.size() / 2, pivot);
        list.set(list.size() - 1, sorted.get(sorted.size() - 1));

        return pivot;
    }

    @NotNull
    private <T extends Comparable> List<T> collect(T pivot, List<T> left, List<T> right) {
        List<T> result = new ArrayList<>(left.size() + right.size() + 1);
        result.addAll(left);
        result.add(pivot);
        result.addAll(right);
        return result;
    }

    @NotNull
    private <T extends Comparable> LinkedList<T> partition(List<T> list, T pivot) {
        LinkedList<T> partitioned = new LinkedList<>();
        partitioned.add(pivot);
        list.forEach(item -> {
            if (item != pivot) {
                if (item.compareTo(pivot) < 0) {
                    partitioned.addFirst(item);
                } else {
                    partitioned.addLast(item);
                }
            }
        });
        return partitioned;
    }
}
