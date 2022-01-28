import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        root.left = left1;
        root.right = right1;

        TreeNode left2 = null;
        TreeNode right2 = null;
        left1.left = left2;
        left1.right = right2;

        TreeNode left3 = new TreeNode(15);
        TreeNode right3 = new TreeNode(7);
        right1.left = left3;
        right1.right = right3;

        LevelOrder lo = new LevelOrder();
        List<List<Integer>> ans = lo.levelOrder(root);
        System.out.println(ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int level = 0;
        traverseOrder(root,ans,level);
        return ans;
    }

    void traverseOrder(TreeNode root, List<List<Integer>> ans, int level) {

        // Base Case
        if(root == null) {
            return;
        }

        // Recursive Case
        if (ans.size() <= level) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(root.val);
            ans.add(tmp);
        } else {
            ans.get(level).add(root.val);
        }

        // Recursive call
        traverseOrder(root.left,ans,level + 1);
        traverseOrder(root.right, ans, level + 1);

    }
}
