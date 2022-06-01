package Subsequence;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int ans = 0;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        ans++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
