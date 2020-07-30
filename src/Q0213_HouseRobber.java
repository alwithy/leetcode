public class Q0213_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // 和198题比起来只是增加了环
        // 分两种情况，1：可以偷nums[0]，去掉nums[nums.length - 1]
        // 2: 可以偷nums[nums.length - 1], 去掉nums[0]
        // 返回结果最大的一种

        // 情况1，去掉最后一个房子
        int dp_iM2 = nums[0];
        int dp_iM1 = Math.max(nums[0], nums[1]);
        int dp_i = dp_iM1;
        for (int i = 2; i < nums.length - 1; i++) {
            dp_i = Math.max(nums[i] + dp_iM2, dp_iM1);
            dp_iM2 = dp_iM1;
            dp_iM1 = dp_i;
        }
        int temp = dp_i;

        // 情况2，去掉第一间房子
        dp_iM2 = nums[1];
        dp_iM1 = Math.max(nums[1], nums[2]);
        dp_i = dp_iM1;
        for (int i = 3; i < nums.length; i++) {
            dp_i = Math.max(nums[i] + dp_iM2, dp_iM1);
            dp_iM2 = dp_iM1;
            dp_iM1 = dp_i;
        }

        return Math.max(temp, dp_i);
    }
}
