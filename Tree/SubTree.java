import java.util.Deque;
import java.util.LinkedList;

public class SubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while(!deque.isEmpty()) {
            int size =deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                if(cur.val == subRoot.val) {
                    boolean res = compare(cur,subRoot);
                    if(res) {
                        return true;
                    }
                }
                if(cur.left != null) {
                    deque.offerLast(cur.left);
                }

                if(cur.right != null) {
                    deque.offerLast(cur.right);
                }
            }
        }
        return false;
    }
    boolean compare(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot != null) {
            return false;
        } else if(root != null && subRoot == null) {
            return false;
        } else if(root == null && subRoot == null) {
            return true;
        } else if(root.val != subRoot.val) {
            return false;
        }

        boolean left = compare(root.left, subRoot.left);
        boolean right = compare(root.right, subRoot.right);

        return left&&right;
    }
}
