public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(res > dp[i]) {
                continue;
            } else {
                res = dp[i];
            }
        }
        return res;
    }
}
