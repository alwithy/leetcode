import java.util.Deque;
import java.util.LinkedList;

public class Q1047_RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String S) {
        //栈解决
        Deque<Character> deque = new LinkedList<>();
        int len = S.length();
        int i = 0;
        while (i < len) {
            while (!deque.isEmpty() && i < len && deque.peekLast() == S.charAt(i)) {
                deque.pollLast();
                i++;
            }
            if (i == len) {
                break;
            }
            deque.addLast(S.charAt(i++));
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaaaaaaa"));
    }
}
