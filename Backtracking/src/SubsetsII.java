import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        int[] num = {1,2,2};
        SubsetsII s = new SubsetsII();
        System.out.println(s.subsetsWithDup(num));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        subsetsHelper(nums,0,used);
        return res;
    }
    void subsetsHelper(int[] nums, int startIndex, boolean[] used) {
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i -1] && used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = false;
            subsetsHelper(nums,i+1,used);
            used[i] = true;
            path.removeLast();
        }
    }
}
