import java.util.Deque;
import java.util.LinkedList;

public class Q0402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        //删除比低位数字大(即从左到右降序)的元素
        for (int i = 0; i < len; i++) {
            char cur = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > cur) {
                deque.pollLast();
                k--;
            }
            deque.addLast(cur);
        }
        // 如果删除次数没用完，删除末尾元素
        while (k > 0 && !deque.isEmpty()) {
            deque.pollLast();
            k--;
        }
        // 去除先导0
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }
        return res.length() == 0? "0" : res.toString();
    }
}
