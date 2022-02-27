public class TrappingRain {
    public int trap(int[] height) {
        if(height.length < 2) {
            return 0;
        }

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int len = height.length;

        // Get each element's left largest value
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[len - 1] = height[len - 1];
        for (int i = len -2; i >= 0 ; i--) {
            maxRight[i] = Math.max(height[i],maxRight[i + 1]);
        }

        int sum = 0;

        for (int i = 0; i < len; i++) {
            int count = Math.min(maxLeft[i],maxRight[i]) - height[i];
            if(count > 0) {
                sum += count;
            }
        }
        return sum;

    }
}
