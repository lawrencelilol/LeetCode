import java.util.HashMap;
import java.util.Map;

public class fourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length;j++) {
                if(map.containsKey(nums1[i] + nums2[j])) {
                    int val = map.get(nums1[i] + nums2[j]) + 1;
                    map.put(nums1[i] + nums2[j], val);
                } else {
                    map.put(nums1[i] + nums2[j],1);
                }
            }
        }

        for(int i: nums3) {
            for(int j : nums4) {
                temp = i + j;
                if(map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
