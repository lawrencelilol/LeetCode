public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStockIII btbss3 = new BestTimeToBuyAndSellStockIII();
        System.out.println(btbss3.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        // dp is the max profit on i th day with j th move
        /*
         * Define 5 moves:
         * 0: no move, 1: buy first time, 2: sell first time, 3: buy second time, 4: sell second time
         */
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < prices.length ; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i -1][1]);
            dp[i][2] = Math.max(prices[i] + dp[i -1][1],dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i -1][2] - prices[i],dp[i -1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + prices[i],dp[i - 1][4]);
        }
        return dp[prices.length -1][4];
    }
}
