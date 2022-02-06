import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        int[] num = {1,2,2};
        Subsets s = new Subsets();
        System.out.println(s.subsets(num));
    }
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums,0);
        return res;
    }
    void subsetsHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums,i+1);
            path.removeLast();
        }
    }
}
