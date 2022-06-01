package Stocks;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length -1][1];
//        int[] dp = new int[2];
//
//        //  [0] owns stock
//        dp[0] = -prices[0];
//        // [1] does not own stock
//        dp[1] = 0;
//
//        for (int i = 1; i <= prices.length; i++) {
//            dp[0] = Math.max(dp[0], -prices[i -1]);
//
//            dp[1] = Math.max(prices[i - 1] + dp[0], dp[1]);
//        }
//        return dp[1];
    }
}
