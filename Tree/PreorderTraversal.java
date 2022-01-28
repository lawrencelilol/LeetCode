
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
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

        PreorderTraversal pt = new PreorderTraversal();
        List<Integer> ans = pt.preorderTraversal(root);
        System.out.println(ans);
    }
//   Recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preOrder(root,result);
        return result;
    }
    void preOrder(TreeNode root, ArrayList<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right,result);
    }
    // 迭代遍历
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        if(root == null) {
//            return result;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while(!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            result.add(node.val);
//
//            if(node.right != null) {
//                stack.push(node.right);
//            }
//
//            if(node.left != null) {
//                stack.push(node.left);
//            }
//        }
//        return result;
//    }

}
