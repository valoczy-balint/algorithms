package sort.heap;

import heap.MinHeapTree;
import sort.Sort;
import tree.BinaryNode;

import java.util.ArrayList;
import java.util.List;

public class HeapSort implements Sort {

    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        T root = list.get(0);
        List<T> result = new ArrayList<>(list.size());
        MinHeapTree<T> minHeap = new MinHeapTree<>(new BinaryNode<>(root));

        for (int i = 1; i < list.size(); i++) {
            minHeap.insert(list.get(i));
        }

        while (!minHeap.isEmpty()) {
            T current = minHeap.delete();
            result.add(current);
        }

        return result;
    }
}
