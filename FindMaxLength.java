import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public static void main(String[] args) {
        int[] nums = {0,1};
        FindMaxLength fml = new FindMaxLength();
        System.out.println(fml.findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count += 1;
            } else {
                count -= 1;
            }
            if(map.containsKey(count)) {
                maxlen = Math.max(maxlen,i - map.get(count));
            } else {
                map.put(count,i);
            }
        }
        return maxlen;
    }
}
