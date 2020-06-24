import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0809_ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        // 双指针法
        int res = 0;
        List<Integer[]> deque = new LinkedList<>();
        // curChar[0]代表字母，curChar[1]代表字母出现的次数
        Integer[] curChar;
        for (int i = 0; i < S.length(); i++) {
            curChar = new Integer[2];
            curChar[0] = S.charAt(i) - 'a';
            curChar[1] = 1;
            while (i + 1 < S.length() && S.charAt(i + 1) == S.charAt(i)) {
                curChar[1]++;
                i++;
            }
            deque.add(curChar);
        }
        for (String word : words) {
            if (isStretchy(deque, word)) res++;
        }

        return res;
    }

    private boolean isStretchy(List<Integer[]> deque,
                               String word) {
        // i指向S
        int i = 0;
        for (int j = 0; j < word.length(); j++) {
            if (i == deque.size()) return false;
            char c = word.charAt(j);
            int num = 1;
            while (j + 1 < word.length() && word.charAt(j + 1) == c) {
                num++;
                j++;
            }

            while (c != (char) (deque.get(i)[0] + 'a')) {
                if (deque.get(i)[1] >= 3) {
                    i++;
                } else {
                    return false;
                }
            }

            // 此时c == (char) (deque.get(i)[0] + 'a')
            if (num > deque.get(i)[1]
                    || (num < deque.get(i)[1] && deque.get(i)[1] < 3)) {
                return false;
            }
            i++;
        }

        return i == deque.size();
    }
}
