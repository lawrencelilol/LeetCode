public class InsertBST {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while(true) {
            if(val < cur.val && cur.left != null) {
                cur = cur.left;
            } else if(val > cur.val && cur.right != null) {
                cur = cur.right;
            } else {
                break;
            }
        }
        TreeNode insert = new TreeNode(val);
        if(val > cur.val) {
            cur.right = insert;
        } else if(val < cur.val) {
            cur.left = insert;
        }
        return root;
    }
}
