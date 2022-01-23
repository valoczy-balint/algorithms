package challenges.candies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Candies {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public long candies(List<Integer> arr) {
        List<Integer> increasingSubseqFromLeft = increasingSubseqFromLeft(arr);
        List<Integer> increasingSubseqFromRight = increasingSubseqFromRight(arr);
        List<Integer> maxed = itemsMax(increasingSubseqFromLeft, increasingSubseqFromRight);

        Integer result = maxed.stream().reduce(0, Integer::sum);
        return result;
    }

    private List<Integer> increasingSubseqFromLeft(List<Integer> input) {
        List<Integer> result = new ArrayList<>(input.size());
        result.add(1);
        for (int i = 1; i< input.size(); i++) {
            Integer current = input.get(i);
            Integer prev = input.get(i - 1);
            if(current == prev) {
                result.add(1);
            } else if(current > prev) {
                result.add(result.get(i - 1) + 1);
            } else {
                result.add(1);
            }
        }
        return result;
    }

    private List<Integer> increasingSubseqFromRight(List<Integer> input) {
        List<Integer> result = new ArrayList<>(input.size());
        result.add(1);
        for (int i = input.size() - 2; i >= 0; i--) {
            Integer current = input.get(i);
            Integer prev = input.get(i + 1);
            if(current == prev) {
                result.add(1);
            } else if(current > prev) {
                Integer previous = result.get(input.size() - i - 2);
                result.add(previous + 1);
            } else {
                result.add(1);
            }
        }
        Collections.reverse(result);
        return result;
    }

    private List<Integer> itemsMax(List<Integer> input1, List<Integer> input2) {
        List<Integer> result = new ArrayList<>(input1.size());
        for(int i = 0; i < input1.size(); i++) {
            result.add(Math.max(input1.get(i), input2.get(i)));
        }
        return result;
    }
}
