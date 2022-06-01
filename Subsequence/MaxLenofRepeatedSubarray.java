package Subsequence;

public class MaxLenofRepeatedSubarray {
    public static void main(String[] args) {
        int[] n1 = {0,0,0,0,0};
        int[] n2 = {0,0,0,0,0};

        System.out.println(findLength(n1, n2));
    }
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (nums2[j] == nums1[0]) {
                dp[0][j] = 1;
                max = 1;
            }
        }


        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }
}
