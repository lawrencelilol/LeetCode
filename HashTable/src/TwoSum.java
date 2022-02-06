import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] output = twoSum(nums,target);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums == null) {
            return nums;
        }
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if(map.containsKey(ans)) {
                res[0] = map.get(ans);
                res[1] = i;
            }
            map.put(nums[i],i);
        }
        return res;
     }
}
