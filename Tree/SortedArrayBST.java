public class SortedArrayBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortedArrayBST sabst = new SortedArrayBST();
        sabst.sortedArrayToBST(nums);

    }
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = traversal(nums,0,nums.length - 1);
        return root;
    }
    public TreeNode traversal(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = traversal(nums,left,mid - 1);
        root.right = traversal(nums,mid + 1, right);

        return root;

    }
}
