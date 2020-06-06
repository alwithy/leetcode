public class Q0005_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        // 中心拓展算法，枚举所有回文可能的中心，向两边拓展
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
             int len = expandAroundCenter(s, i, i);
             if (len > end - start + 1) {
                 start = i - (len - 1)/2;
                 end = i + (len - 1)/2;
             }
             if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                 len = expandAroundCenter(s, i, i + 1);
                 if (len > end - start + 1) {
                     start = i - len/2 + 1;
                     end = i + len/2;
                 }
             }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left > 0 && right < s.length() - 1
                && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
