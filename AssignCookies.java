import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};

        AssignCookies ac = new AssignCookies();

        System.out.println(ac.findContentChildren(g,s));
    }
//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int count = 0;
//        int start = 0;
//        for (int i = 0; i < g.length && start < s.length; i++) {
//            if(s[start] >= g[i]) {
//                start++;
//                count++;
//            }
//        }
//        return count;
//    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        for (int i = g.length - 1; i >= 0 ; i--) {
            if(start >= 0 && g[i] <= s[start]) {
                count++;
                start--;
            }
        }
        return count;
    }
}
