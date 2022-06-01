package Subsequence;

public class DeleteOperationforTwoStrings {
    public static void main(String[] args) {
        String w1 = "leetcode";
        String w2 = "etco";

        System.out.println(minDistance(w1,w2));
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length(); i++) {
            char a = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++) {
                char b = word2.charAt(j);
                int idx1 = i + 1;
                int idx2 = j + 1;
                if (a == b) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2],dp[idx1][idx2 - 1]);
                }
            }
        }

        int common = dp[word1.length()][word2.length()];

        return word1.length() - common + word2.length() - common;
    }
}
