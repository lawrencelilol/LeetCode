public class StrStr {
    public static void main(String[] args) {
        int a = 32;
        int b = 3;
        System.out.println(a/b);
        String s = "aabaaf";
        int[] next = new int[s.length()];
        StrStr ss = new StrStr();
        ss.getNext(next,s);
    }
    public void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;

        for (int i = 1; i < s.length(); i++) {
            while(j >= 0 && s.charAt(j + 1) != s.charAt(i)) {
                j = next[j];
            }
            if(s.charAt(j + 1) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    public int strStr(String haystack, String needle) {

        return -1;
    }
}
