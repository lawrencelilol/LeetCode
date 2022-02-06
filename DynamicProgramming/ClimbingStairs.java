public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(n));
    }
//    public int climbStairs(int n) {
//        if(n <= 2) {
//            return n;
//        }
//
//        int c = 0;
//        int a = 1;
//        int b = 2;
//        for (int i = 2; i < n; i++) {
//            c = a + b;
//
//            a = b;
//            b = c;
//        }
//        return c;
//    }

    // Backpack version
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] weight = {1,2};

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < weight.length ; j++) {
                if(i - weight[j] >= 0) {
                    dp[i] += dp[i - weight[j]];
                }
            }
        }
        return dp[n];
    }
}
