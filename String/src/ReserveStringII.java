public class ReserveStringII {

    public static void main(String[] args) {
        ReserveStringII r = new ReserveStringII();
        String s = "abcdefg";
        int k = 2;
        r.reverseStr(s,k);
    }

    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i += 2*k){
            int start = i;

            int end = Math.min(c.length - 1, start + k - 1);

            while(start < end) {
                // swap start and end
                char tmp = c[end];
                c[end] = c[start];
                c[start] = tmp;
                start ++;
                end--;
            }
        }
        return new String(c);
    }

}
