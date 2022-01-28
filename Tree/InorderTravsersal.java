import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTravsersal {
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

       InorderTravsersal it = new InorderTravsersal();
        List<Integer> ans = it.inorderTraversal(root);

        System.out.println(ans);
    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        Inorder(root,ans);
//        return ans;
//
//    }
//    void Inorder(TreeNode root, List<Integer> res) {
//        if(root == null) {
//            return;
//        }
//
//        Inorder(root.left,res);
//        res.add(root.val);
//        Inorder(root.right,res);
//    }

    //迭代遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

}
