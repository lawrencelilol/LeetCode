public class OnesAndZeros {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 3;
        int n = 3;

        OnesAndZeros oz = new OnesAndZeros();
        System.out.println(oz.findMaxForm(strs,m,n));
        oz.testCompletePackAnotherWay();
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s: strs) {
            int ones = 0, zeros = 0;
            for(char c: s.toCharArray()) {
                if(c == '0') {
                    zeros++;
                }else {
                    ones++;
                }
            }
            for(int i = m; i >= zeros; i--){
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){
            for (int j = 0; j < weight.length; j++){
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }
}
