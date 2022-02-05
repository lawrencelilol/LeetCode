public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,4,1,1};
        LastStoneWeight lsw = new LastStoneWeight();
        System.out.println(lsw.lastStoneWeightII(stones));
    }
    public int lastStoneWeightII(int[] stones) {
        int sum  = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum/2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum -dp[target] - dp[target];
    }
}
