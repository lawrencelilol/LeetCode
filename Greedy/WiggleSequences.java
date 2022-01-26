public class WiggleSequences {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        WiggleSequences ws = new WiggleSequences();
        System.out.println(ws.wiggleMaxLength(nums));
     }
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1 || nums == null) {
            return nums.length;
        }

        int curSign;
        int preSign = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curSign = Integer.signum(nums[i] - nums[i - 1]);
            if((curSign < 0 && preSign >= 0) || (curSign > 0 && preSign <= 0)) {
                count++;
                preSign = curSign;
            }
        }
        return count;
    }
}
