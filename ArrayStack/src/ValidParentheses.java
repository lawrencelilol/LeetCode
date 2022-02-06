import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(){}}{";

        System.out.println(isValid(s));

    }
    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if(ch == '(') {
                deque.push(')');
            } else if( ch == '[') {
                deque.push(']');
            } else if(ch == '{') {
                deque.push('}');
            } else if(deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
