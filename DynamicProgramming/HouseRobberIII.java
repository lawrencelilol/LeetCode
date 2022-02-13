

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
     }
  }

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if(root == null) {
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // Steal cur node's money
        res[1] = root.val + left[0] + right[0];
        // Don't Steal cur node's money
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return res;
    }
}
