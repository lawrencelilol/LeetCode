public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(s.equals("")) {
            return false;
        }

        int len = s.length();

        s = " " + s;

        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        for (int i =2, j = 0; i <= len; i++) {
            while(j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            if(chars[i] == chars[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        if(next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}
