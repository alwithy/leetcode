import java.util.ArrayDeque;
import java.util.Deque;

public class Q0678_ValidParenthesisString {
    public static boolean checkValidString1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 用栈分别存放左括号和星号
        // 时间O(n),空间O(n)
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (!left.isEmpty()) {
                    left.pollLast();
                } else if (!star.isEmpty()) {
                    star.pollFirst();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '*') {
                star.addLast(i);
            }
        }
        // 此时left和star都是按序号从小到大排序的
        while (!left.isEmpty()) {
            while (!star.isEmpty() && star.peek() < left.peek()) {
                star.pollFirst();
            }
            if (star.isEmpty()) return false;
            left.pollFirst();
            star.pollFirst();
        }

        return true;
    }

    public static boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 贪心算法，使用变量lo和hi来表示可能多余的左括号的数量
        // 当前字符为'(', lo++, hi++
        // 当前字符为')', lo--, hi--
        // 当前字符为'*', lo--, hi++
        // 如果lo--之后会小于0，则我们取lo为0，
        // 因为lo代表的是当所有星号都为右括号时剩余左括号的数量
        // 当左括号数量不够时，我们可以让一部分星号成为空字符，让左右括号刚好配对
        // 若遇到hi < 0,则返回false
        int hi = 0;
        int lo = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                hi++;
                lo++;
            } else if (c == ')') {
                hi--;
                lo--;
            } else { // c == *
                hi++;
                lo--;
            }
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }

        return lo == 0;
    }

    public static void main(String[] args) {
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        System.out.println(checkValidString(s));
    }
}
