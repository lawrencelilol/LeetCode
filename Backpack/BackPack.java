package Backpack;

public class BackPack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        System.out.println(backpack2(weight, value, bagWeight));
    }

    public static int backpack(int[] weight, int[] value, int bagWeight){
        int weightSize = weight.length;

        int[][] dp = new int[weightSize + 1][bagWeight + 1];

        for (int i = 0; i <= weightSize; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= weightSize; i++) { // item
            for (int j = 1; j <= bagWeight; j++) {   // bag
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int lastVal = value[i - 1];
                    int lastWeight = weight[i - 1];
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - lastWeight] +lastVal);
                }
            }
        }
        return dp[weightSize][bagWeight];
    }

    /**
     * 滚动数组法
     *
     */
    public static int backpack2(int[] weight, int[] value, int bagWeight) {
        int weightSize = weight.length;

        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < weightSize; i++) {
            for (int j = bagWeight; j >= weight[i] ; j--) {
                int w = weight[i];
                int v = value [i];
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        return dp[bagWeight];
    }
}
