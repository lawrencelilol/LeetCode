import com.sun.source.tree.Tree;

import java.util.*;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        root.left = left1;
        root.right = right1;


        left1.left = null;
        left1.right = null;

        TreeNode left3 = new TreeNode(15);
        TreeNode right3 = new TreeNode(7);
        right1.left = left3;
        right1.right = right3;

        RightSideView rsv = new RightSideView();
        List<Integer> ans = rsv.rightSideView(root);
        System.out.println(ans);

    }
    // Recursive Solution
//    public List<Integer> rightSideView(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        int level = 0;
//        traverseOrder(root,ans,level);
//        List<Integer> output = new ArrayList<>();
//        for (List<Integer> an : ans) {
//            for (int j = 0; j < an.size(); j++) {
//                if (j == an.size() - 1) {
//                    output.add(an.get(j));
//                }
//            }
//        }
//        return output;
//    }
//
//    void traverseOrder(TreeNode root, List<List<Integer>> ans, int level) {
//
//        // Base Case
//        if(root == null) {
//            return;
//        }
//
//        // Recursive Case
//        if (ans.size() <= level) {
//            List<Integer> tmp = new ArrayList<Integer>();
//            tmp.add(root.val);
//            ans.add(tmp);
//        } else {
//            ans.get(level).add(root.val);
//        }
//        // Recursive call
//        traverseOrder(root.left,ans,level + 1);
//        traverseOrder(root.right, ans, level + 1);
//    }
    // 迭代法
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize ; i++) {
                TreeNode node = queue.pollFirst();

                if(node.left != null) {
                    queue.offerLast(node.left);
                }
                if(node.right != null) {
                    queue.offerLast(node.right);
                }
                if(i == qSize - 1) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

}
