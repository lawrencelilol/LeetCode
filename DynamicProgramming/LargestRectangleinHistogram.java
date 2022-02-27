public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] minLeftIdx = new int[len];
        int[] maxRightIdx = new int[len];

        minLeftIdx[0] = -1;
        for (int i = 1; i < minLeftIdx.length; i++) {
            int t = i - 1;
            while(t >= 0 && heights[t] >= heights[i]) {
                t = minLeftIdx[t];
            }
            minLeftIdx[i] = t;
        }
        maxRightIdx[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int t = i + 1;
            while(t < len && heights[t] >= heights[i]) t = maxRightIdx[t];
            maxRightIdx[i] = t;
        }
        // sum
        int result = 0;
        for (int i = 0; i < len; i++) {
            int sum = heights[i] * (maxRightIdx[i] - minLeftIdx[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }
}
