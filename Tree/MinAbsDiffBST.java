import java.util.ArrayList;
import java.util.List;

public class MinAbsDiffBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);

        MinAbsDiffBST mad = new MinAbsDiffBST();
        System.out.println(mad.getMinimumDifference(root));
    }

    int result = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
    void traversal(TreeNode root) {
        if(root == null) {
            return;
        }
        traversal(root.left);
        if(pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
