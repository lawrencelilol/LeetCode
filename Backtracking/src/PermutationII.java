import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        PermutationII p = new PermutationII();
        System.out.println(p.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteUniqueHelper(nums,used);
        return res;
    }

    void permuteUniqueHelper(int[] nums, boolean[] used) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if(i > 0 && nums[i] == nums[i -1] && used[i -1] == false){
                continue;
            }
            if(used[i] == false) {
                path.add(nums[i]);
                used[i] = true;
                permuteUniqueHelper(nums,used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
