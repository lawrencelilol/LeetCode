import java.util.Stack;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] t = {73,74,75,71,69,72,76,73};

        int[] ans = dailyTemperatures(t);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        int[] ans = new int[temperatures.length];
        temp.push(0);

        for (int i = 0; i < temperatures.length; i++) {

            while(!temp.isEmpty() && temperatures[i] > temperatures[temp.peek()]) {
                ans[temp.peek()] = i - temp.peek();
                temp.pop();
            }
            temp.push(i);
        }
        return ans;
    }
}
