package HouseRobber;

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
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robHelper(TreeNode root) {
        int[] dp = new int[2];

        if (root == null) {
            return dp;
        }

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }
}
