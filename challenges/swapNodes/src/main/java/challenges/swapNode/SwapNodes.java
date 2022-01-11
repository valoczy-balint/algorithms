package challenges.swapNode;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem
public class SwapNodes {

    public List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> output = new ArrayList<>();
        for (Integer query : queries) {
            swap(indexes, query, 1, 1);
            List<Integer> result = new ArrayList<>();
            inOrder(indexes, 1, result);
            output.add(result);
        }
        return output;
    }

    private void swap(List<List<Integer>> indexes, int k, int currentIndex, int currentHeight) {
        List<Integer> currentNode = indexes.get(currentIndex - 1);
        Integer currentLeft = currentNode.get(0);
        Integer currentRight = currentNode.get(1);

        if (currentLeft != -1) {
            swap(indexes, k, currentLeft, currentHeight + 1);
        }
        if (currentHeight % k == 0) {
            currentNode.set(0, currentRight);
            currentNode.set(1, currentLeft);
        }
        if (currentRight != -1) {
            swap(indexes, k, currentRight, currentHeight + 1);
        }
    }

    private void inOrder(List<List<Integer>> indexes, int currentIndex, List<Integer> result) {
        List<Integer> currentNode = indexes.get(currentIndex - 1);
        Integer currentLeft = currentNode.get(0);
        Integer currentRight = currentNode.get(1);

        if (currentLeft != -1) {
            inOrder(indexes, currentLeft, result);
        }
        result.add(currentIndex);
        if (currentRight != -1) {
            inOrder(indexes, currentRight, result);
        }
    }
}
