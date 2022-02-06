import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    public static void main(String[] args) {
        String[] words = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
//        String[] words = {"bella","label","roller"};
        List<String> ans = commonChars(words);
        for (String s: ans) {
            System.out.println(s);
        }

    }

    public static List<String> commonChars(String[] words) {

       int[][] count = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for(char c: words[i].toCharArray()) {
                count[i][c - 'a'] += 1;
            }
        }

        int[] countChars = new int[26];

        for (int i = 0; i < words[0].length(); i++) {
            countChars[words[0].charAt(i) - 'a']++;
        }


        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i].length; j++) {
                countChars[j] = Math.min(countChars[j], count[i][j]);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < countChars.length; i++) {
            if(countChars[i] > 0) {
                if(countChars[i] > 1) {
                    for (int j = 0; j < countChars[i]; j++) {
                        char c = (char) (i+97);
                        ans.add(String.valueOf(c));
                    }
                } else {
                    char c = (char) (i+97);
                    ans.add(String.valueOf(c));
                }
            }
        }
        return ans;
    }
}
