public class PartitionSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for(int s: nums) {
            sum += s;
        }

        if(sum%2 != 0) {
            return false;
        }

        int target = sum/2;

        int[] dp = new int[target+1];

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;

    }
}
