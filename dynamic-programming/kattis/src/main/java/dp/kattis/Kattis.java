package dp.kattis;

import kotlin.Pair;

import java.util.Arrays;
import java.util.List;

public class Kattis {

    private int half;

    public Pair<Integer, Integer> splitWeightEvenly(Integer[] items) {
        int total = Arrays.stream(items).reduce(0, Integer::sum);
        half = total / 2;

        int best = findClosestToHalf(items[0], items[0], Arrays.asList(items));
        int other = total - best;

        return new Pair<>(Math.max(best, other), Math.min(other, best));
    }

    private int findClosestToHalf(int current, int best, List<Integer> items) {
        if (items.isEmpty()) {
            return best;
        }

        Integer next = items.get(0);
        if (Math.abs(current + next - half) < Math.abs(best - half)) {
            best = current + next;
        }

        int best1 = findClosestToHalf(current + next, best, items.subList(1, items.size()));
        int best2 = findClosestToHalf(current, best, items.subList(1, items.size()));

        if (Math.abs(best1 - half) < Math.abs(best2 - half)) {
            return best1;
        } else {
            return best2;
        }
    }

    public Pair<Integer, Integer> splitWeightEvenlyDynamic(Integer[] items) {
        int total = Arrays.stream(items).reduce(0, Integer::sum);
        half = total / 2;

        int best = findClosestSubSumDynamicProgramming(items, half);
        int other = total - best;

        return new Pair<>(Math.max(best, other), Math.min(other, best));
    }

    private int findClosestSubSumDynamicProgramming(Integer[] items, int target) {
        Integer[][] cache = new Integer[items.length][target];

        for (int row = 0; row < items.length; row++) {
            for (int col = 0; col < target; col++) {
                Integer currentItem = items[row];

                if (row == 0) {
                    if(col >= currentItem) {
                        cache[row][col] = currentItem;
                    } else {
                        cache[row][col] = 0;
                    }
                } else if (currentItem > col + 1) {
                    cache[row][col] = cache[row - 1][col];
                } else {
                    //Option 1: Using current item
                    int optimalSolutionUsingCurrentItem = -1;
                    int weightLeft = col + 1 - currentItem;
                    if (weightLeft == 0) {
                        optimalSolutionUsingCurrentItem = currentItem;
                    } else if (weightLeft > 0) {
                        optimalSolutionUsingCurrentItem = currentItem + cache[row - 1][weightLeft - 1];
                    }

                    //Option 2: Not using current item
                    int optimalSolutionNotUsingCurrentItem = cache[row - 1][col];

                    cache[row][col] = Math.max(optimalSolutionUsingCurrentItem, optimalSolutionNotUsingCurrentItem);
                }
            }
        }
        return cache[items.length - 1][target - 1];
    }
}
