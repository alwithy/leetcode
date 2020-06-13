public class Q0151_ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        if (s == null || s.length() == 0) {
            return res.toString();
        }

        // 从后往前读取,双指针法
        int i = s.length() - 1;
        int j = s.length();
        StringBuilder cur;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s, i + 1, j);
            res.append(' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            j = i + 1;
        }

        if (res.length() > 0 && res.charAt(0) == ' ') {
            res.deleteCharAt(0);
        }

        if (res.length() > 0 &&  res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
