import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pemutation {


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Pemutation p = new Pemutation();
        System.out.println(p.permute(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums,used);
        return res;
    }
    void permuteHelper(int[] nums, boolean[] used) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] == true) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            permuteHelper(nums,used);
            path.removeLast();
            used[i] = false;
        }
    }
}
