public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        System.out.println(args.length);
    }
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];

        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            int tmp = dp[0];
            int tmp1 = dp[2];
            dp[0] = Math.max(dp[0],Math.max(dp[3], dp[1]) - prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = tmp + prices[i - 1];
            dp[3] = tmp1;
        }
        return Math.max(dp[3], Math.max(dp[1],dp[2]));
    }
}
