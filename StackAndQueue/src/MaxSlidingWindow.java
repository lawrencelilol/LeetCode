import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[]nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] ans = msw.maxSlidingWindow(nums,k);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (i - k + 1 >= 0) {
                ans[idx++] = nums[queue.peek()];

            }
        }
        return ans;
    }
}
