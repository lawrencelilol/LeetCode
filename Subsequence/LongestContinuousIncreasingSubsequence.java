package Subsequence;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};

        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
