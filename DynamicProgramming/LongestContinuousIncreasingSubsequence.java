import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {2};
        LongestContinuousIncreasingSubsequence lcis = new LongestContinuousIncreasingSubsequence();
        System.out.println(lcis.findLengthOfLCIS(nums));
    }
//    public int findLengthOfLCIS(int[] nums) {
//        int max = 1;
//        int count = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] > nums[i - 1]) {
//                count++;
//                max = Math.max(count, max);
//            } else {
//                count = 1;
//            }
//        }
//        return max;
//    }

    // Dynamic Programming
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            if(res > dp[i + 1]) {
                continue;
            } else {
                res = dp[i + 1];
            }
        }
        return res;
    }
}
