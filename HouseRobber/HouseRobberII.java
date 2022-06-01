package HouseRobber;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a = robHelper(nums,0 , nums.length - 2);
        int b = robHelper(nums, 1,  nums.length - 1);

        return Math.max(a, b);
    }

    private static int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
