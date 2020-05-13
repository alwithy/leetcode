public class Q0209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 动态规划解决问题
        // sum记录最近的子数组的和
        int sum = 0;
        int curLength = 0;
        int res = Integer.MAX_VALUE;
        boolean hasSub = false;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            curLength++;
            if (sum >= s) {
                hasSub = true;
                while (sum - nums[i - curLength + 1] >= s) {
                    sum -= nums[i - curLength + 1];
                    curLength--;
                }
                res = Math.min(res, curLength);
            }
        }

        return hasSub ? res : 0;
    }
}
