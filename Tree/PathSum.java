import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PathSum {
   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      TreeNode l1 = new TreeNode(4);
      TreeNode r1 = new TreeNode(8);
      root.left = l1;
      root.right = r1;

      TreeNode l2 = new TreeNode(11);
      l1.left = l2;

      TreeNode l3 = new TreeNode(7);
      TreeNode r3 = new TreeNode(2);
      l2.left = l3;
      l2.right = r3;

      TreeNode l4 = new TreeNode(13);
      TreeNode r4 = new TreeNode(4);
      r1.left = l4;
      r1.right = r4;

      TreeNode r5 = new TreeNode(1);
      r4.right = r5;

      PathSum ps = new PathSum();
      System.out.println(ps.hasPathSum(root,22));

   }
   // Recursive
//   public boolean hasPathSum(TreeNode root, int targetSum) {
//      if(root == null) {
//         return false;
//      }
//      targetSum -= root.val;
//
//      if(root.left == null && root.right == null) {
//         return targetSum == 0;
//      }
//
//      if(root.left != null) {
//         boolean res = hasPathSum(root.left,targetSum);
//         if(res) {
//            return true;
//         }
//      }
//
//      if(root.right != null) {
//         boolean res = hasPathSum(root.right,targetSum);
//         if(res) {
//            return true;
//         }
//      }
//      return false;
//   }
   public boolean hasPathSum(TreeNode root, int targetSum) {
      if(root == null) {
         return false;
      }

      Stack<TreeNode> treeStack = new Stack<>();
      Stack<Integer> sums = new Stack<>();
      treeStack.push(root);
      sums.push(root.val);

      while(!treeStack.isEmpty()){
         int size = treeStack.size();
         for (int i = 0; i < size; i++) {
            TreeNode cur = treeStack.pop();
            int sum = sums.pop();

            if(cur.left == null && cur.right == null && sum == targetSum) {
               return true;
            }

            if(cur.left != null) {
               treeStack.push(cur.left);
               sums.push(sum + cur.left.val);
            }

            if(cur.right != null) {
               treeStack.push(cur.right);
               sums.push(sum + cur.right.val);
            }
         }
      }
      return false;
   }
}
