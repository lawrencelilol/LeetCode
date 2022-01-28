import java.util.Deque;
import java.util.LinkedList;

public class LCAofBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LCAofBST lcabst = new LCAofBST();
        TreeNode p = root.left;
        TreeNode q = root.left.right;

        TreeNode s  = lcabst.lowestCommonAncestor(root, p, q);
        System.out.println(s.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            if(left != null) {
                return left;
            }
        }

        if(root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(right != null) {
                return right;
            }
        }
        return root;
    }
}
