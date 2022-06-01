package Subsequence;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            for (int j = 0; j < t.length(); j++) {
                char b = t.charAt(j);
                int idx1 = i + 1;
                int idx2 = j + 1;
                if (a == b) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + dp[idx1 - 1][idx2];
                } else {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
