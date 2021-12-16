public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = calculatePrefixes(nums);
        int[] postfixes = calculatePostfixes(nums);

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixes[i] * postfixes[i];
        }

        return result;
    }

    private int[] calculatePrefixes(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        return result;
    }

    private int[] calculatePostfixes(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        return result;
    }
}
