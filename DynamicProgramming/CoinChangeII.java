public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        CoinChangeII cc2 = new CoinChangeII();
        System.out.println(cc2.change(amount,coins));
    }
    public int change(int amount, int[] coins) {
        int sum = 0;
        for(int i: coins) {
            sum += i;
        }
        if(sum < amount) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
