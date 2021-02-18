public class Q0995_MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        //滑动窗口法
        //  结果      当前位置翻转计数
        int res = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i >= K && A[i - K] > 1) {
                count -= 1;
                A[i - K] -= 2;
            }
            if ((A[i] + count) % 2 == 0) {
                if (i > A.length - K) {//此时无法翻转
                    return -1;
                }
                res++;
                count++;
                A[i] += 2;//做标记，证明我们翻转过
            }
        }

        return res;
    }
}
