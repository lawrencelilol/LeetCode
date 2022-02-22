public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int len = 0;
        int ans = 0;
        if(s == null || (len = s.length()) < 1) {
            return 0;
        }

        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
