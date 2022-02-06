public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {9};
        int t = 3;
        CombinationSum4 cs4 = new CombinationSum4();
        System.out.println(cs4.combinationSum4(nums,t));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
