package Backpack;
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += nums[i];
        }

        if ((target + sum) % 2 != 0) {
            return 0;
        }

        int size = (target + sum) / 2;
        if (size < 0) {
            size = -size;
        }

        int[] dp = new int[size + 1];

        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
