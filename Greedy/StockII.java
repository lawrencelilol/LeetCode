public class StockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        StockII stockII = new StockII();
        System.out.println(stockII.maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int profits = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if((prices[i] - prev) > 0) {
                profits += prices[i] - prev;
            }
            prev = prices[i];
        }
        return profits;
    }
}
