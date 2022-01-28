public class BuildTree {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        int[] preorder = {3,9,20,15,7};

        BuildTree bt = new BuildTree();
//        TreeNode root = bt.buildTree(inorder,postorder);
        TreeNode root1 = bt.buildTree(preorder,inorder);
    }
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        return buildTreeI(inorder,0,inorder.length, postorder,0,postorder.length);
//    }

    public TreeNode buildTreeI(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {

        // If inorder array is empty
        if(inRight - inLeft < 1) {
            return null;
        }

        // If inorder array has one element
        if(inRight - inLeft  == 1) {
            return new TreeNode(inorder[inLeft]);
        }

        // Else
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);

        int index = 0;
        for (int i = inLeft; i < inRight; i++) {
            if(rootVal == inorder[i]){
                index = i;
                break;
            }
        }

        root.left = buildTreeI(inorder,inLeft,index, postorder,postLeft,postLeft + (index - inLeft));
        root.right = buildTreeI(inorder, index + 1, inRight,postorder,postLeft + (index - inLeft),postRight - 1);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeII(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode buildTreeII(int[]preorder,int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {

        // Base Case:
        if(inRight - inLeft < 1) {
            return null;
        }

        if(inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        // Use inorder to split left and right trees
        // Find the root's idx in inorder array
        int idx = 0;
        for (int i = inLeft; i < inRight; i++) {
            if(rootVal == inorder[i]){
                idx = i;
                break;
            }
        }

        // Recursive Case
        // when splitting close on the left side and open on the right side
        root.left = buildTreeII(preorder,preLeft + 1,preLeft + (idx - inLeft), inorder,inLeft,idx);
        root.right = buildTreeII(preorder,preLeft + (idx - inLeft) + 1,preRight,inorder, idx + 1,inRight);

        return root;
    }
}
