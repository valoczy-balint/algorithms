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
}
