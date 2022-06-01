package Stocks;

public class BestTimetoBuyandSellStockwithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[prices.length][4];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < prices.length ; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return  Math.max(dp[n -1][3], Math.max(dp[n -1][1],dp[n - 1][2]));
    }
}
