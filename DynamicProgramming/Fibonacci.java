public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(n));
    }
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }
        int c = 0;
        int a = 1;
        int b = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return c;
    }
}
