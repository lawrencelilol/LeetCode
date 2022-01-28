import java.util.Deque;
import java.util.LinkedList;

public class SumOfLeft {


    // iterative
//    public int sumOfLeftLeaves(TreeNode root) {
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offerLast(root);
//        int sum = 0;
//        while(!deque.isEmpty()) {
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = deque.pollFirst();
//
//                if(cur.left != null && cur.left.left == null && cur.left.right == null) {
//                    sum += cur.left.val;
//                }
//                if(cur.right != null) {
//                    deque.offerLast(cur.right);
//                }
//                if(cur.left != null) {
//                    deque.offerLast(cur.left);
//                }
//            }
//        }
//        return sum;
//    }

    // Recursive
    public int sumOfLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftValues = sumOfLeaves(root.left);
        int rightValues = sumOfLeaves(root.right);

        int values = 0;

        if(root.left != null && root.left.left == null && root.left.right == null) {
            values = root.left.val;
        }
        int sum = leftValues+values+rightValues;
        return sum;
    }
}
