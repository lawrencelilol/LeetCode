package Subsequence;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            char a = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                char b = text2.charAt(j);
                int idx1 = i + 1;
                int idx2 = j + 1;
                if (a == b) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
