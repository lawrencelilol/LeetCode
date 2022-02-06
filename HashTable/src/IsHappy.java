import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));

    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
            System.out.println("n: " + n);
        }
        if(n == 1) {
            return true;
        } else {
            return false;
        }
    }
    private static int getSum(int n) {
        int res = 0;
        while(n > 0) {
            res += (n%10)*(n%10);
            n = n/10;
        }
        return res;
    }
}
