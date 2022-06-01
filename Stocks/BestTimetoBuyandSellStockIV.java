package Stocks;

public class BestTimetoBuyandSellStockIV {


    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
    public static int maxProfit(int k, int[] prices) {

        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int n = 2*k + 1;
        int[][] dp = new int[prices.length][n];

        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < n; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                }
            }
        }

        return dp[prices.length - 1][n - 1];
    }
}
