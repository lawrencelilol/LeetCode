public class ReverseLeftWord {
    public static void main(String[] args) {
        ReverseLeftWord rlw = new ReverseLeftWord();
        String s = "abcdefg";

        System.out.println(rlw.reverseLeftWords(s,2));
    }
    public String reverseLeftWords(String s, int n) {

        char[] ans = new char[s.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int idx = i - n;
            if(idx < 0) {
                idx = s.length() + idx;
                ans[idx] = s.charAt(i);
            } else{
                ans[idx] = s.charAt(i);
            }
        }

        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}
