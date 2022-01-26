public class JumpGame {
    public static void main(String[] args) {
        int[]nums = {3,2,1,0,4};
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int range = 0;
        for (int i = 0; i <= range; i++) {
            range = Math.max(nums[i] + i,range);
            if(range >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
