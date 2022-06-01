package CompleteBackpack;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String ss = s.substring(j, i);
                if (wordDict.contains(ss) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
