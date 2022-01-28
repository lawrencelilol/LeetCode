import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevel {
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

        AverageOfLevel aol = new AverageOfLevel();
        System.out.println(aol.averageOfLevels(root));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();

                if(node.left != null) {
                    deque.offerLast(node.left);
                }
                if(node.right != null) {
                    deque.offerLast(node.right);
                }
                sum += node.val;
            }
            ans.add(sum/size);
        }
        return ans;
    }
}
