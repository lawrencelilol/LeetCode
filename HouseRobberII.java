public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }

        int res1 = robHouse(nums,0, nums.length -2);
        int res2 = robHouse(nums,1, nums.length -1);


        return Math.max(res1,res2);


    }

    public int robHouse(int[] nums, int start, int end) {
       if(start == end) {
           return nums[end];
       }
       
       int[] dp = new int[nums.length];
       dp[start] = nums[start];
       dp[start + 1] = Math.max(nums[start + 1], nums[start]);
        for (int i = start + 2; i <= end ; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end];
    }
}
