public class Q0674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        //动态规划,res[i]代表以nums[i]结尾的递增子序列的长度
        int[] res = new int[nums.length];
        int max = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
            max = Math.max(max,res[i]);
        }
        return max;
    }
}
