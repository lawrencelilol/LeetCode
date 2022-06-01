public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(n));
    }
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        int c = 0;
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            c = a + b;

            a = b;
            b = c;
        }
        return c;
    }
}
