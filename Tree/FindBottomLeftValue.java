import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int leftMost = 0;
        if(root == null) {
            return leftMost;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                if(i == 0) {
                    leftMost = cur.val;
                }

                if(cur.left != null) {
                    deque.offerLast(cur.left);
                }
                if(cur.right != null) {
                    deque.offerLast(cur.right);
                }
            }
        }
        return leftMost;
    }
}
