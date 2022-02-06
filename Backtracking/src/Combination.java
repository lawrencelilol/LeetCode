import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        Combination c = new Combination();
        System.out.println(c.combine(4,2));
    }
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n,k,1);
        return res;
    }
    void combineHelper(int n, int k, int startIndex) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combineHelper(n,k,i+1);
            path.removeLast();
        }
    }
}
