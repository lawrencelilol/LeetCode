import java.util.Deque;
import java.util.LinkedList;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(7);
        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        left1.left = left2;
        left1.right = right2;

        TreeNode left3 = new TreeNode(6);
        TreeNode right3 = new TreeNode(9);
        right1.left = left3;
        right1.right = right3;

        InvertTree it = new InvertTree();
        it.invertTree(root);
    }
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null) {
//            return null;
//        }
//
//        Deque<TreeNode> deque = new LinkedList<>();
//
//        deque.offerLast(root);
//
//        while(!deque.isEmpty()) {
//            int size = deque.size();
//            TreeNode right = null;
//            TreeNode left = null;
//
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = deque.pollFirst();
//                TreeNode tmp = cur.left;
//                cur.left = cur.right;
//                cur.right = tmp;
//
//                if(cur.right != null) {
//                    deque.offerLast(cur.right);
//                }
//
//                if(cur.left != null) {
//                    deque.offerLast(cur.left);
//                }
//            }
//        }
//        return root;
//    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right =tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
