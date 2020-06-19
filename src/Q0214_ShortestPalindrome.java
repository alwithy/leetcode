public class Q0214_ShortestPalindrome {
    public static String shortestPalindrome1(String s) {
        // 暴力法,O(n^2),超时
        if (s == null || s.length() < 1)    return "";
        if (s.length() == 1)    return s;
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                break;

            }
        }
        return new StringBuilder(s.substring(i + 1)).reverse() + s;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        if (start == end) return true;
        char[] c = s.toCharArray();
        while (end > start) {
            if (c[start] != c[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static String shortestPalindrome2(String s) {
        // KMP算法
        // 将s翻转保存为rev，目标是寻找s最长的前缀，使之与rev的后缀相等
        if (s == null || s.length() < 1)    return "";
        if (s.length() == 1)    return s;
        String rev = new StringBuilder(s).reverse().toString();
        String sNew = s + "#" + rev;
        int[] next = new int[sNew.length()];
        next[0] = 0;
        for (int i = 1; i < sNew.length(); i++) {
            int temp = next[i - 1];
            while (temp > 0 && sNew.charAt(i) != sNew.charAt(temp)) {
                temp = next[temp - 1];
            }
            if (sNew.charAt(i) == sNew.charAt(temp)) {
                temp++;
            }
            next[i] = temp;
        }

        return rev.substring(0, s.length() - next[next.length - 1]) + s;
    }

    public static void main(String[] args) {
       String s = "aacecaaa";
        System.out.println(shortestPalindrome1(s));
    }
}
