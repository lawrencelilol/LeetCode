import java.util.Deque;
import java.util.LinkedList;

public class IsSameTree {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        return compare(p,q);
    }
    boolean compare(TreeNode p, TreeNode q) {
        if(p == null && q != null) {
            return false;
        }else if(p != null && q == null) {
            return false;
        } else if(p == null && q == null) {
            return true;
        } else if(p.val != q.val) {
            return false;
        }

        boolean left  = compare(p.left,q.left);
        boolean right = compare(p.right,q.right);

        return left&&right;
    }
}
