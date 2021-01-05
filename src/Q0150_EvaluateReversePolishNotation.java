import java.util.Deque;
import java.util.LinkedList;

public class Q0150_EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            char c = s.charAt(0);
            if (c >= '0' && c <= '9' || s.length() > 1) {
                stack.addLast(Integer.parseInt(s));
            } else {
                int num2 = stack.pollLast();
                int num1 = stack.pollLast();
                int res;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.addLast(res);
            }
        }

        return stack.pollLast();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
