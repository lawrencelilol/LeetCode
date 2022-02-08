public class PerfectSquares {
    public static void main(String[] args) {
        int n = 3;
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(n));
    }
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];

        for (int i = 0; i < dp.length ; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j < dp.length; j++) {
                if(j - i*i != max) {
                    dp[j] = Math.min(dp[j - i*i] + 1, dp[j]) ;
                }
            }
        }

        return dp[n];
    }
}
