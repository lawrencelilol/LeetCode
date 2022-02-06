import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII cs3 = new CombinationSumIII();
        System.out.println(cs3.combinationSum3(3,7));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationHelper(n,k,0,1);
        return res;
    }

    void combinationHelper(int targetSum, int k , int sum, int startIndex) {
        if(sum > targetSum) {
            return;
        }
        if(path.size() == k) {
            if(sum == targetSum) {
                List<Integer> found = new ArrayList<>(path);
                res.add(found);
            }
            return;
        }

        for (int i = startIndex; i <= 9 ; i++) {
            path.add(i);
            sum += i;
            combinationHelper(targetSum,k,sum,i+1);
            path.removeLast();
            sum -= i;
        }
    }
}
