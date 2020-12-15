public class Q0738_MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int N) {
        if (N <= 0) {
            return 0;
        }
        int[] num = new int[10];
        int i = 9;
        while (N > 0) {
            num[i--] = N % 10;
            N /= 10;
        }
        i = 1;
        while (i < 10) {
            if (num[i] < num[i - 1]) {
                minusOne(num, i - 1);
                break;
            }
            i++;
        }
        int res = 0;
        for (i = 0; i < 10; i++) {
            res = res * 10 + num[i];
        }
        return res;
    }

    public static void minusOne(int[] num, int index) {
        while (index > 0 && num[index - 1] == num[index]) {
            index--;
        }
        num[index++]--;
        while (index < num.length) {
            num[index++] = 9;
        }
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(monotoneIncreasingDigits(num));
    }
}
