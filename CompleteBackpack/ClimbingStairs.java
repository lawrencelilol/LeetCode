package CompleteBackpack;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i] += dp[i - j];
            }
        }

        return dp[n];
    }
}
