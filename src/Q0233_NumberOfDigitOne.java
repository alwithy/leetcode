public class Q0233_NumberOfDigitOne {
    public static int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        int len = getLength(n);
        if (n == 1) {
            return 1;
        }
        int temp1 = (int) Math.pow(10, len - 1);
        //首位数字
        int first = n / temp1;
        //首位上的1
        int firstOneNum = first == 1 ? n % temp1 + 1 : temp1;
        //其他位上的1
        int otherOneNum = first * (len - 1) * (temp1 / 10);

        return firstOneNum + otherOneNum + countDigitOne(n % temp1);
    }

    public static int getLength(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
