import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottom {
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

        LevelOrderBottom lob = new LevelOrderBottom();
        List<List<Integer>> ans = lob.levelOrderBottom(root);
        System.out.println(ans);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int level = 0;
        bottomTraversal(root,res,level);

        Collections.reverse(res);
        return res;
    }

    void bottomTraversal(TreeNode root, List<List<Integer>> res,int level) {
        if(root == null) {
            return;
        }

        if(res.size() <= level) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(root.val);
            res.add(tmp);
        } else {
            res.get(level).add(root.val);
        }

        bottomTraversal(root.left,res,level + 1);
        bottomTraversal(root.right,res,level + 1);

    }
}
