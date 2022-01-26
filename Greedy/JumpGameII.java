public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        JumpGameII jg2 = new JumpGameII();
        System.out.println(jg2.jump(nums));
    }
    public int jump(int[] nums) {
        if(nums.length == 1 || nums == null || nums.length == 0) {
            return 0;
        }

        int range = 0;
        int count = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            range = Math.max(i + nums[i], range);

            if(range >= nums.length - 1) {
                count++;
                break;
            }

            if(i == cur) {
                count++;
                cur = range;
            }
        }
        return count;
    }
}
