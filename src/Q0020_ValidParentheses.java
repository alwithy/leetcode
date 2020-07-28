import java.util.Deque;
import java.util.LinkedList;

public class Q0020_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        // stack解决
        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !valid(stack.pop(), c)) {
                    return false;
                }
            }
            i++;
        }

        return stack.isEmpty();
    }

    private boolean valid(Character c1, char c2) {
        return (c1 == '(' && c2 == ')')
                || (c1 == '[' && c2 == ']')
                || (c1 == '{' && c2 == '}');
    }
}
