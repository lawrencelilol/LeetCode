package CompleteBackpack;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(5));
    }
    public static int numSquares(int n) {
        if (n <= 1) {
            return n;
        }

        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max);

        int amount = n / 2;
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i - j*j >= 0) {
                    dp[i] = Math.min(dp[i],dp[i - j*j] + 1);
                }
            }
        }
        return dp[n];
    }
}
