import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindModeBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);

        FindModeBST fmbst = new FindModeBST();

        System.out.println(fmbst.findMode(root));
    }

    int maxCount;
    int count;
    TreeNode pre;
    List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        pre = null;
        res.clear();

        traversal(root);

        return res.stream().mapToInt(Integer::intValue).toArray();

    }
    void traversal(TreeNode root) {
        if(root == null) {
            return;
        }
        traversal(root.left);

        if (pre == null) {
            count = 1;
        } else if(pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        pre = root;

        if(count == maxCount) {
            res.add(root.val);
        }

        if(count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(root.val);
        }

        traversal(root.right);

        return;
    }
}
