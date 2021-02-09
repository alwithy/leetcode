public class Q0992_SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        if (K <= 1) {
            return  K == 0 ? 0 : A.length;
        }
        //滑动窗口法，官方题解
        return mostKDistinct(A, K) - mostKDistinct(A, K - 1);
    }

    //最多包含k个不同数字的子数组的数量
    public int mostKDistinct(int[] arr, int k) {
        //窗口范围为[l..r]
        int l = 0, r = -1;
        int count = 0;//窗口中不同数字的数量
        int n = arr.length;
        int[] freq = new int[n + 1];//各个数字出现的频率
        int res = 0;
        while (r + 1 < n) {
            r++;
            if (freq[arr[r]] == 0) {
                count++;
            }
            freq[arr[r]]++;

            while (count > k) {
                freq[arr[l]]--;
                if (freq[arr[l]] == 0) {
                    count--;
                }
                l++;
            }

            res += r - l + 1;
        }

        return res;
    }
}
