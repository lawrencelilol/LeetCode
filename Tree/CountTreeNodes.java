import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CountTreeNodes {
    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        TreeNode left3 = new TreeNode(6);

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;
        TreeNode right1 = new TreeNode(3);
        right1.left = left3;
        root.left = left1;
        root.right = right1;

        CountTreeNodes ctn = new CountTreeNodes();
        System.out.println(ctn.countNodes(root));


    }
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null) {
            return count;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);


        while(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                count++;

                if(cur.left != null) {
                    deque.offer(cur.left);
                }
                if(cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return count;
    }


}
