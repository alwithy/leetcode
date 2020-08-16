public class Q0028_ImplementFunction {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() < needle.length()) return -1;
        int res = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            res = strStr(haystack, i, needle);
            if (res != -1) break;
        }

        return res;
    }

    public int strStr(String s1, int index, String s2) {
        int res = index;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(index + i) != s2.charAt(i)) {
                res = -1;
                break;
            }
        }

        return res;
    }
}
