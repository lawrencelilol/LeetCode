import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreaseSubsequences {
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};

        IncreaseSubsequences is = new IncreaseSubsequences();
        System.out.println(is.findSubsequences(nums));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums,0);
        return res;
    }


    void helper(int[] nums, int start) {
        if(path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1) || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            helper(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }
}
