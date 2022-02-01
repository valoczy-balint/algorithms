package challenges.slidingWindowMaximum;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            Integer max = null;

            for (int j = i; j < i + k; j++) {
                if (max == null || nums[j] > max) {
                    max = nums[j];
                }
            }

            result[i] = max;
        }

        return result;
    }
}
