public class Q0327_CountOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        // 官方题解，对前缀和进行归并排序
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return countByMergeSort(sum, lower, upper, 0, sum.length - 1);
    }

    public static int countByMergeSort(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        int res = countByMergeSort(sum, lower, upper, left, mid)
                + countByMergeSort(sum, lower, upper, mid + 1, right);
        int i = left;
        int l = mid + 1, r = mid + 1;

        // 计算区间数量
        while (i <= mid) {
            while (l <= right && sum[l]  - sum[i] < lower) l++;
            //if (l == right + 1) break;
            while (r <= right && sum[r] - sum[i] <= upper) r++;
            res += r - l;
            i++;
        }

        // 合并两个有序数组
        long[] help = new long[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p3 = 0;
        while (p1 <= mid && p2 <= right) {
            help[p3++] = sum[p1] < sum[p2]? sum[p1++] : sum[p2++];
        }
        while (p1 <= mid) help[p3++] = sum[p1++];
        while (p2 <= right) help[p3++] = sum[p2++];
        p3 = 0;
        while (p3 < help.length) {
            sum[left + p3] = help[p3];
            p3++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2147483647,-2147483648,-1,0};
        int lower = -1;
        int upper = 0;
        System.out.println(countRangeSum(arr, lower, upper));
    }
}
