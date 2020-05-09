public class Q0152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 动态规划解决，保留最小值和最大值
        int max = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            max = Math.max(iMax, max);
        }

        return max;
    }
}
