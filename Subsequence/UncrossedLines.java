package Subsequence;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int idx1 = i + 1;
                int idx2 = j + 1;
                if (nums1[i] == nums2[j]) {
                    dp[idx1][idx2] = dp[idx1- 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
