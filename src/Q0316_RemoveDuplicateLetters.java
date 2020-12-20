import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q0316_RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] rest = new int[26];
        for (int i = 0; i < s.length(); i++) {
            rest[s.charAt(i) - 'a']++;
        }
        //单调栈
        Deque<Character> deque = new LinkedList<>();
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!used[c - 'a']) {
                while (!deque.isEmpty() && deque.peekLast() > c
                        && rest[deque.peekLast() - 'a'] > 0) {
                    char poll = deque.pollLast();
                    used[poll - 'a'] = false;
                }
                deque.addLast(c);
                used[c - 'a'] = true;
            }
            rest[c - 'a']--;
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "cdadabcc";
        System.out.println(removeDuplicateLetters(s));
    }
}
