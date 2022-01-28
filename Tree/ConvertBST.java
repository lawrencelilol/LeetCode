public class ConvertBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left = new TreeNode(2);

        ConvertBST cBST = new ConvertBST();
        cBST.convertBST(root);

    }
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
    void traversal(TreeNode cur) {
        if(cur == null) {
            return;
        }

        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
        return;
    }
}
