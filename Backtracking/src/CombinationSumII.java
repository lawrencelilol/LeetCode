import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        CombinationSumII cs2 = new CombinationSumII();
        System.out.println(cs2.combinationSum2(candidates,8));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        combinationHelper(candidates,target,0,0,used);
        return res;
    }

    void combinationHelper(int[] candidates, int target, int sum, int startIndex, boolean[] used){
        if(sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i - 1] && used[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = false;
            combinationHelper(candidates,target,sum,i + 1,used);
            sum -= candidates[i];
            used[i] = true;
            path.removeLast();
        }
    }
}
