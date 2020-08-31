public class Q0058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int cur = 0;
        int i = 0;
        int len = s.length();
        while (i < len) {
            while (i < len && s.charAt(i) == ' ') i++;
            if (i == len) break;
            cur = 0;
            while (i < len && s.charAt(i) != ' ') {
                cur++;
                i++;
            }
            i++;
        }

        return cur;
    }
}
