public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int t = 3;

        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(nums,t));
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if((target + sum)%2 == 1) return 0;

        if(Math.abs(target) > sum) {
            return 0;
        }

        int size = (target + sum)/2;
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
