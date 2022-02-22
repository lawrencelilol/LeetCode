public class DeleteOperationTwoStrings {
    public int minDistance(String word1, String word2) {

        // define dp array
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // initialize the data
        for (int i = 0; i < word1.length() + 1 ; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i -1][j -1] + 2,Math.min(dp[i - 1][j] + 1,dp[i][j -1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
