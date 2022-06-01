package Subsequence;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < word1.length(); i++) {
            char a = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++) {
                char b = word2.charAt(j);

                int idx1 = i + 1;
                int idx2 = j + 1;

                if (a == b) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1];
                } else {
                    dp[idx1][idx2] = Math.min(dp[idx1 - 1][idx2], Math.min(dp[idx1][idx2 - 1],dp[idx1 - 1][idx2 - 1])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
