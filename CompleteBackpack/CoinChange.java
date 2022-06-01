package CompleteBackpack;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins  = {1,2,5};
        System.out.println(coinChange(coins, 11));
    }
    public static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] =  0;

//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                if (dp[j - coins[i]] != max) {
//                    dp[j] = Math.min(dp[j], dp[j- coins[i]] + 1);
//                }
//            }
//        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++)  {
                if ( i  - coins[j] >= 0 && dp[i - coins[j]] != max) {
                    dp[i] = Math.min(dp[i], dp[i- coins[j]] + 1);
                }
            }
        }

        if (dp[amount] == max) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
