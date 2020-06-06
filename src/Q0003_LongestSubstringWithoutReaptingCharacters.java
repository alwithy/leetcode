import java.util.HashMap;
import java.util.HashSet;

public class Q0003_LongestSubstringWithoutReaptingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 类似滑动窗口的思想，依次计算以每一个元素结尾的最长不重复子串
        // 遇到重复元素时，左指针依次向右移动，知道没有重复元素为止
        int res,left,right;
        res = left = right = 0;
        HashSet<Character> curSub = new HashSet<>();
        char cur;
        while (right < s.length()) {
            cur = s.charAt(right);
            while (curSub.contains(cur)) {
                curSub.remove(s.charAt(left++));
            }
            curSub.add(cur);
            res = Math.max(res, curSub.size());
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
