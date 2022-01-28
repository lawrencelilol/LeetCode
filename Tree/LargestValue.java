import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2);
        root.left = left1;
        root.right = right1;


        left1.left = new TreeNode(5);
        left1.right = new TreeNode(3);

        TreeNode right3 = new TreeNode(9);
        right1.left = null;
        right1.right = right3;

        LargestValue lv = new LargestValue();
        List<Integer> ans = lv.largestValues(root);

        System.out.println(ans);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            int qSize = deque.size();
            int max = deque.peek().val;

            for (int i = 0; i < qSize ; i++) {
                TreeNode cur = deque.pollFirst();
                if(cur.left != null) {
                    deque.offerLast(cur.left);
                }
                if(cur.right != null) {
                    deque.offerLast(cur.right);
                }
                max = Math.max(max,cur.val);
            }
            ans.add(max);
        }
        return ans;
    }
}
