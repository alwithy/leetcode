public class Q0930_BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //滑动窗口法
        int res = 0;
        //窗口范围为[l1..r] [l2..r]
        int len = nums.length;
        int sum1 = 0, sum2 = 0;
        int l1 = 0, l2 = 0, r = 0;
        while (r < len) {
            sum1 += nums[r];
            while (l1 <= r && sum1 > goal) {
                sum1 -= nums[l1];
                l1++;
            }

            sum2 += nums[r];
            while (l2 <= r && sum2 >= goal) {
                sum2 -= nums[l2];
                l2++;
            }

            res += l2 - l1;
        }
        return res;
    }
}
