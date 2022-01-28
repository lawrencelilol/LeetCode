import java.util.Arrays;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        MaximumBinaryTree mbt = new MaximumBinaryTree();

        TreeNode root = mbt.constructMaximumBinaryTree(nums);

    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node = new TreeNode(0);
        if(nums.length == 1) {
            node.val = nums[0];
            return node;
        }

        int maxValue = 0;
        int maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
                maxIdx = i;
            }
        }
        node.val = maxValue;

        //Left f

        if(maxIdx > 0) {
            int[] leftNums = Arrays.copyOfRange(nums,0,maxIdx);
            node.left = constructMaximumBinaryTree(leftNums);
        }

        if( maxIdx < nums.length - 1) {
            int[] rightNums = Arrays.copyOfRange(nums,maxIdx + 1,  nums.length);
            node.right = constructMaximumBinaryTree(rightNums);
        }

        return node;
    }
}
