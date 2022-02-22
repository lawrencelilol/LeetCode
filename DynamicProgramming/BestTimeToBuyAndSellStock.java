public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock btbss = new BestTimeToBuyAndSellStock();
        System.out.println(btbss.maxProfit(prices));
    }
//    public int maxProfit(int[] prices) {
//        int result = 0;
//        int low = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            low = Math.min(prices[i],low);
//            result = Math.max(result,prices[i] - low);
//        }
//        return result;
//    }
    // Dynamic Programming
    public int maxProfit(int[] prices) {
        int len = prices.length;

        // dp[i][0] max profit if owns stock on i th day
        // dp[i][1] max profit if does not own stock on i th day
        int[][] dp = new int[len][2];
        int result = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < len ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[len-1][1];
    }
}
