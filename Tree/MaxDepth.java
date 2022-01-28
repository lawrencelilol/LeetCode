import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {
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

        MaxDepth md = new MaxDepth();
        System.out.println(md.maxDepth(root));
    }
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {

                TreeNode cur = deque.pollFirst();

                if(cur.left != null) {
                    deque.offerLast(cur.left);
                }
                if(cur.right != null) {
                    deque.offerLast(cur.right);
                }
            }
            level++;
        }
        return level;
    }

}
