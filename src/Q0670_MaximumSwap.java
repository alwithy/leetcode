public class Q0670_MaximumSwap {
    public static int maximumSwap(int num) {
        int[] bit = new int[9];
        for (int i = 0; i < 9; i++) {
            bit[i] = num / ((int) Math.pow(10, 8 - i));
            num -= bit[i] * ((int) Math.pow(10, 8 - i));
        }
        int i = 0;
        //找到数字的最高位
        for (; i < bit.length; i++) {
            if (bit[i] > 0) {
                break;
            }
        }

        int max;
        for (; i < bit.length; i++) {
            max = i;
            for (int j = i + 1; j < bit.length; j++) {
                //此处要找的max是数字最大且位数最低的
                max = bit[max] > bit[j] ? max : j;
            }
            if (bit[i] < bit[max]) {
                //交换
                int temp = bit[i];
                bit[i] = bit[max];
                bit[max] = temp;
                break;
            }
        }

        //生成结果
        num = 0;
        for (int j = 0; j < 9; j++) {
            num += bit[j] * ((int) Math.pow(10, 8 - j));
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }
}
