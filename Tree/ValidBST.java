import java.util.Stack;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        ValidBST vbst = new ValidBST();
        System.out.println(vbst.isValidBST(root));
    }

    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            if (pre != null && pre.val <= cur.val) {
                return false;
            }
            pre = cur;

            root = cur.right;
        }
        return true;
    }
}
