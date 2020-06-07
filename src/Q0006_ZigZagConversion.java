public class Q0006_ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        // 首行元素
        for (int i = 0; i < s.length(); i += (numRows - 1) * 2) {
            res.append(s.charAt(i));
        }
        // 中间行元素
        for (int i = 1; i < numRows - 1; i++) {
            boolean isOddRow = false;
            for (int j = i; j < s.length();
                 j += isOddRow ? 2 * (numRows - 1 - i) : 2 * i) {
                res.append(s.charAt(j));
                isOddRow = !isOddRow;
            }
        }
        // 末行元素
        for (int i = numRows - 1; i < s.length(); i += (numRows - 1) * 2) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 3));
    }
}
