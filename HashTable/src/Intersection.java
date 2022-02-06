import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] out = intersection(nums1,nums2);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for(int i: nums2) {
            if(set.contains(i)) {
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];

        int count = 0;
        for(int i : res) {
            ans[count++] = i;
        }
        return ans;
    }
}
