package Subsequence;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                char b = s.charAt(j);
                int idx1 = i + 1;
                int idx2 = j + 1;

                if (a == b) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1 - 1][idx2 - 1]);
                }
            }
        }

        return dp[t.length()][s.length()] == s.length();
    }
}
