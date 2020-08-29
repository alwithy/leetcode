public class Q0038_CountAndSay {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            res = core(res);
        }

        return res.toString();
    }

    private StringBuilder core(StringBuilder s) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int count;
        char curChar;
        while (i < s.length()) {
            curChar = s.charAt(i);
            count = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == curChar) {
                count++;
                i++;
            }
            res.append(count).append(curChar);
            i++;
        }

        return res;
    }
}
