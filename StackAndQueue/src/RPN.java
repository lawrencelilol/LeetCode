import java.util.Stack;

public class RPN {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        RPN rpn = new RPN();
        System.out.println(rpn.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s: tokens) {
            int ans;
            if(s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                ans = a/b;
                stack.push(ans);
            } else if(s.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                ans = a+b;
                stack.push(ans);
            } else if(s.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                ans = a*b;
                stack.push(ans);
            } else if(s.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                ans = a - b;
                stack.push(ans);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
