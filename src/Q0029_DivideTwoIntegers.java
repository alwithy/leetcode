import java.util.ArrayList;
import java.util.List;

public class Q0029_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) return -1;
        // 首先用负数存储，计算完毕后再转化为正数
        int flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ?
                -1 : 1;
        dividend *= dividend > 0 ? -1 : 1;// 被除数
        divisor *= divisor > 0 ? -1 : 1;// 除数
        List<Integer[]> list = new ArrayList<>();
        int cur = divisor;
        int time = 1;
        while (cur >= dividend) {
            list.add(new Integer[]{cur, time});
            if (cur == Integer.MIN_VALUE || cur - Integer.MIN_VALUE + cur < 0) break;
            cur += cur;
            time += time;
        }
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer[] temp = list.get(i);
            if (dividend <= temp[0]) {
                dividend -= temp[0];
                res -= temp[1];
            }
            if (dividend > divisor) break;
        }

        if (res + Integer.MAX_VALUE < 0 && flag == -1) {
            res = Integer.MAX_VALUE;
        } else {
            res *= flag;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647
                ,3));
    }
}
