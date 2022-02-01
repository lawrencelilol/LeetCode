public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3 ; i <= n; ++i) {
            for (int j = 1; j < i - 1; ++j) {
                int cur = Math.max(j*(i-j), j*dp[i-j]);
                dp[i] = Math.max(dp[i],cur);
            }
        }
        return dp[n];
    }
}
