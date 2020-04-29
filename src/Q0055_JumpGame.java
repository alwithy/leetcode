public class Q0055_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length < 1) {
            return true;
        }
        //贪心法
        int right = nums[0];
        if (right == 0) {
            return false;
        }
        for (int i = 0; i < nums.length && i < right; i++) {
            right = Math.max(i + nums[i], right);
        }
        return right >= nums.length - 1;
    }
}
