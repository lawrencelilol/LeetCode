import java.util.HashMap;
import java.util.Map;

public class canConstruct {
    public static void main(String[] args) {
        String r = "aa";
        String m = "aab";

        System.out.println(canConstruct(r,m));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int temp;

        for(char c: magazine.toCharArray()) {
            temp = c - 'a';
            count[temp]++;
        }

        for(char c: ransomNote.toCharArray()) {
            temp = c - 'a';
            count[temp]--;
        }

        for (int j : count) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }
}
