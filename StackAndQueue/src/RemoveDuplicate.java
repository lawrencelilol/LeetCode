import java.util.Stack;

public class RemoveDuplicate {
    public static void main(String[] args) {
        RemoveDuplicate rd = new RemoveDuplicate();
        String s = "abbaca";

        String ans = rd.removeDuplicates(s);

        System.out.println(ans);
    }
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        String ans = "";

        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;

    }
}
