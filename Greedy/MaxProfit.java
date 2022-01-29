public class MaxProfit {
    public static void main(String[] args) {
        int[]prices = {1,3,2,8,4,9};
        int fee = 2;

        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(prices,fee));
    }
    public int maxProfit(int[] prices, int fee) {
        int minPrice = prices[0];
        int sum = 0;

        for (int p : prices) {
            if(p < minPrice) {
                minPrice = p;
            }

           if(p > minPrice + fee) {
               sum += p - minPrice - fee;
               minPrice = p - fee;
           }
        }

        return sum;
    }
}
