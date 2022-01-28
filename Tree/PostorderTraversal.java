
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(6);
        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;

        TreeNode left3 = new TreeNode(7);
        TreeNode right3 = new TreeNode(8);
        right1.left = left3;
        right1.right = right3;

        PostorderTraversal pt = new PostorderTraversal();
        List<Integer> ans = pt.postorderTraversal(root);

        System.out.println(ans);

    }
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        postOrder(root,res);
//        return res;
//
//    }
//    public void postOrder(TreeNode root, List<Integer> res) {
//        if(root == null) {
//            return;
//        }
//        postOrder(root.left, res);
//        postOrder(root.right, res);
//        res.add(root.val);
//    }

    // 迭代遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
