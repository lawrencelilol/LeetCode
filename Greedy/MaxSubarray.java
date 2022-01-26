public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int count = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum,count);
            if(count <= 0) {
                count = 0;
            }
        }
        return sum;
    }
}
