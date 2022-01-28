import java.util.Deque;
import java.util.LinkedList;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        root.left = l1;
        root.right = r1;

        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        r1.left = l2;
        r1.right = r2;

        BalancedBinaryTree bbt = new BalancedBinaryTree();
        System.out.println(bbt.isBalanced(root));
    }
    public boolean isBalanced(TreeNode root) {
        int res = getHeight(root);
        return res != -1;
    }

    int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }

        int result;
        if(Math.abs(leftHeight - rightHeight) > 1) {
            result = -1;
        } else {
            result = 1 + Math.max(leftHeight,rightHeight);
        }

        return result;
    }

}
