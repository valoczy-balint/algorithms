package challenges.runningMedian;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://www.hackerrank.com/challenges/find-the-running-median/problem
public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> inputs) {
        List<Double> result = new ArrayList<>(inputs.size());
        // Has the smaller numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // Has the bigger numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Integer input : inputs) {
            if(maxHeap.isEmpty()) {
                maxHeap.add(input);
            } else if(input < maxHeap.peek()) {
                maxHeap.add(input);
            } else {
                minHeap.add(input);
            }

            int sizeDifference = minHeap.size() - maxHeap.size();
            System.out.println("Size diff: " + sizeDifference);

            Double median;

            if(sizeDifference > 1) {
                maxHeap.add(minHeap.remove());
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else if(sizeDifference < -1) {
                minHeap.add(maxHeap.remove());
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else if(sizeDifference == 1) {
                median = Double.valueOf(minHeap.peek());
            } else if( sizeDifference == -1) {
                median = Double.valueOf(maxHeap.peek());
            } else {
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            }

            // Round double to 1 decimal
            BigDecimal bigDecimal = new BigDecimal(median).setScale(1, RoundingMode.HALF_UP);
            result.add(bigDecimal.doubleValue());
        }
        return result;
    }
}
