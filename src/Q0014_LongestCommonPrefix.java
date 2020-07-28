public class Q0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            res = commonPrefix(strs[i], res);
            if (res.length() == 0) return res.toString();
        }

        return res.toString();
    }

    private StringBuilder commonPrefix(String s, StringBuilder sb) {
        int i = -1;
        int length = Math.min(s.length(), sb.length());
        while (i + 1 < length && s.charAt(i + 1) == sb.charAt(i + 1)) {
            i++;
        }
        StringBuilder res = new StringBuilder();
        if (i >= 0) {
            res.append(s.substring(0, i + 1));
        }
        return res;
    }
}
