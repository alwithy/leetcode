public class Q0065_ValidNumber {
    public boolean isNumber(String s) {
        char[] arr = s.trim().toCharArray();
        boolean foundNotion = false; // 正负号
        boolean foundNum = false; // 数字
        boolean foundE = false; // e
        boolean foundDot = false; // .
        // "E"不合法
        // "1."和"-.1"都合法

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-' || arr[i] == '+') {
                if (foundNotion || foundNum || (foundDot && !foundE)) return false;
                foundNotion = true;
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                foundNum = true;
            } else if (arr[i] == '.') {
                if (foundDot) return false;
                foundDot = true;
            } else if (arr[i] == 'e') {
                if (foundE || !foundNum) return false;
                foundDot = true;
                foundNotion = false;
                foundNum = false;
                foundE = true;
            } else {
                return false;
            }
        }

        return foundNum;
    }
}
