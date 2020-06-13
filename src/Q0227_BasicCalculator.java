import java.util.ArrayDeque;
import java.util.Deque;

public class Q0227_BasicCalculator {
    public static int calculate(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        // 用*, / 来分割表达式,分别把结果放入栈中，最后统一计算
        Deque<Integer> deque = new ArrayDeque<>();
        char lastOp = '+';
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;

            if (Character.isDigit(s.charAt(i))) {
                cur = s.charAt(i) - '0';
                while (i + 1 < s.length()
                        && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    cur = cur * 10 + (s.charAt(i) - '0');
                }

                if (lastOp == '+') {
                    deque.push(cur);
                } else if (lastOp == '-') {
                    deque.push(-cur);
                } else {
                    deque.push(compute(lastOp, deque.pollFirst(), cur));
                }
            } else {
                lastOp = s.charAt(i);
            }
        }

        for (int num : deque) res += num;

        return res;
    }

    private static int compute(char lastOp, int pre, int cur) {
        if (lastOp == '*') {
            return pre * cur;
        } else {
            // lastOp == '/'
            return pre / cur;
        }
    }

    public static void main(String[] args) {
        String s = "42";
        System.out.println(calculate(s));
    }
}
