public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        int n = 100;
        MonotoneIncreasingDigits mid = new MonotoneIncreasingDigits();
        System.out.println(mid.monotoneIncreasingDigits(n));
    }
    public int monotoneIncreasingDigits(int n) {
        if(n == 0) {
            return 0;
        }
        char[] chars = Integer.toString(n).toCharArray();
        int flag = Integer.MAX_VALUE;
        for (int i = chars.length - 1; i > 0 ; i--) {
            if(chars[i - 1] > chars[i]) {
                chars[i -1]--;
                flag = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '0' && i == 0) {
                continue;
            }
            if(i >= flag) {
                res.append('9');
            }else {
                res.append(chars[i]);
            }
        }
        return Integer.parseInt(res.toString());
    }
}
