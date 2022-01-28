import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(8);
        root.left = l1;
        root.right = r1;

        TreeNode l2 = new TreeNode(11);
        l1.left = l2;

        TreeNode l3 = new TreeNode(7);
        TreeNode r3 = new TreeNode(2);
        l2.left = l3;
        l2.right = r3;

        TreeNode l4 = new TreeNode(13);
        TreeNode r4 = new TreeNode(4);
        r1.left = l4;
        r1.right = r4;

        TreeNode r5 = new TreeNode(1);
        TreeNode l5 = new TreeNode(5);

        r4.left = l5;
        r4.right = r5;

        PathSumII ps2 = new PathSumII();

        System.out.println(ps2.pathSum(root,22));

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) {
            return res;
        }

        traversal(root,targetSum,res,path);
        return res;
    }
    void traversal(TreeNode root, int targetSum,List<List<Integer>> res,List<Integer> path) {
        path.add(root.val);
        targetSum -= root.val;

        if(root.left == null && root.right == null) {
            if(targetSum == 0) {
                res.add(new ArrayList<>(path));
            } else {
                return;
            }
        }

        if(root.left != null) {
            traversal(root.left, targetSum, res, path);
            path.remove(path.size() - 1);
        }

        if(root.right != null) {
            traversal(root.right,targetSum,res,path);
            path.remove(path.size() - 1);
        }
    }
}
