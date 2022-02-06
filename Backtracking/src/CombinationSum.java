import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {


    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(candidates,8));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationHelper(candidates,target,0,0);
        return res;
    }
    void combinationHelper(int[] candidates, int target, int sum, int startIndex) {
        if(sum > target) {
            return;
        }

        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex ; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            combinationHelper(candidates,target,sum,i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
