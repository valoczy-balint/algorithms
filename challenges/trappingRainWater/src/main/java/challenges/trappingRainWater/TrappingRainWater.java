package challenges.trappingRainWater;

public class TrappingRainWater {
        public int trap(int[] height) {
            int[] maxLeft = calculateMaxLeft(height);
            int[] maxRight = calculateMaxRight(height);
            int[] min = new int[height.length];

            int result = 0;
            for(int i = 0; i < height.length; i++) {
                min[i] = Math.min(maxLeft[i], maxRight[i]);
                int diff = min[i] - height[i];
                if(diff > 0) {
                    result += diff;
                }
            }
            return result;
        }

        private int[] calculateMaxLeft(int[] height) {
            int leftMax = height[0];
            int[] result = new int[height.length];
            result[0] = 0;
            for(int i = 1; i < height.length; i++) {
                if(height[i-1] > leftMax) {
                    leftMax = height[i-1];
                }
                result[i] = leftMax;
            }
            return result;
        }

        private int[] calculateMaxRight(int[] height) {
            int rightMax = height[height.length - 1];
            int[] result = new int[height.length];
            result[height.length - 1] = 0;

            for(int i = height.length - 2; i >= 0; i--) {
                if(height[i+1] > rightMax) {
                    rightMax = height[i+1];
                }
                result[i] = rightMax;
            }
            return result;
        }
}
