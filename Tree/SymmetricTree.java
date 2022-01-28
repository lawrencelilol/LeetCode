import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {
//    // Recursive
//
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) {
//            return false;
//        }
//
//        return isSymmetry(root.left,root.right);
//
//    }
//    boolean isSymmetry(TreeNode left, TreeNode right) {
//        if(left == null && right != null) {
//            return false;
//        } else if(left != null && right == null) {
//            return false;
//        } else if(left == null && right == null) {
//            return true;
//        } else if(left.val != right.val) {
//            return false;
//        }
//
//        boolean leftTree = isSymmetry(left.left,right.right);
//        boolean rightTree = isSymmetry(left.right,right.left);
//        boolean isSame = leftTree&&rightTree;
//
//        return isSame;
//    }
      public boolean isSymmetric(TreeNode root) {
          if (root == null) {
              return false;
          }
          Deque<TreeNode> deque = new LinkedList<>();
          deque.offerLast(root.left);
          deque.offerLast(root.right);

          while (!deque.isEmpty()) {
              TreeNode left = deque.pollFirst();
              TreeNode right = deque.pollFirst();

              if(left == null && right == null) {
                  continue;
              }
              if (left == null || right == null || left.val != right.val) {
                  return false;
              }
              if (left.left != null) {
                  deque.offerLast(left.left);
              }
              if (right.right != null) {
                  deque.offerLast(right.right);
              }
              if (left.right != null) {
                  deque.offerLast(left.right);
              }
              if (right.left != null) {
                  deque.offerLast(right.left);
              }
          }
          return true;
      }
}
