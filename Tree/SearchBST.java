public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }

        if(root.val > val) {
           TreeNode left = searchBST(root.left,val);
           return left;
        }

        if(root.val < val) {
            TreeNode right = searchBST(root.right,val);
            return right;
        }

        return null;
    }
}
