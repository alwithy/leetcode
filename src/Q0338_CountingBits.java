public class Q0338_CountingBits {
    public int[] countBits(int num) {
        //官方题解2，动态规划
        int[] res = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }
}
