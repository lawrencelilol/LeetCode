import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BinaryTreePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;

        TreeNode r2 = new TreeNode(5);
        l1.right = r2;

        BinaryTreePath btp = new BinaryTreePath();
        List<String> ans = btp.binaryTreePaths(root);
        System.out.println(ans);
    }
    // Recursive
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        if(root == null) {
//            return res;
//        }
//
//        List<Integer> path = new ArrayList<>();
//        traversal(root,res,path);
//        path.remove(path.size() - 1);
//        return res;
//    }
//
//    void traversal(TreeNode root, List<String>res, List<Integer>path) {
//        path.add(root.val);
//        if(root.left == null && root.right == null) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < path.size() - 1; i++) {
//                sb.append(path.get(i) + "->");
//            }
//            sb.append(path.get(path.size() - 1));
//            res.add(sb.toString());
//        }
//        if(root.left != null) {
//            traversal(root.left,res,path);
//            path.remove(path.size() - 1);
//        }
//        if(root.right != null) {
//            traversal(root.right,res,path);
//            path.remove(path.size() - 1);
//        }
//    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val + "");

        while(!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode cur = (TreeNode) stack.pop();

            if(cur.left == null && cur.right == null) {
                res.add(path);
            }

            if(cur.left != null) {
                stack.push(cur.left);
                stack.push(path + "->" + cur.left.val);
            }

            if(cur.right != null) {
                stack.push(cur.right);
                stack.push(path + "->" + cur.right.val);
            }
        }
        return res;
    }
}
