public class Q0647_PalindromicSubstrings {
    public static int countSubstrings(String s) {
        // 中心拓展法
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int center = 0; center <= 2 * s.length() - 1; center++) {
            int left = center/2;
            int right = left + (center & 1);
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }

        return res;
    }

    public static void  main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
}
