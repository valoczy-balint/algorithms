public class MaxContinousSumInSubarray {
    public int kadane(int[] input) {
        int maxSum = input[0];
        int currentSum = input[0];

        for (int i = 1; i < input.length; i++) {
            currentSum = Math.max(currentSum + input[i], input[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
