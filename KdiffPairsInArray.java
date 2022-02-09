import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInArray {
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2 ;
        KdiffPairsInArray kdpa = new KdiffPairsInArray();
        System.out.println(kdpa.findPairs(nums,k));
    }
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        int res = 0;
        for (int i : map.keySet()) {
            if( k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1) {
                res ++;
            }
        }
        return res;
    }
}
