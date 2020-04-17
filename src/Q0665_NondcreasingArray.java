public class Q0665_NondcreasingArray {
    public static boolean checkPossibility(int[] nums) {
        boolean hasChanged = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (hasChanged) {
                    return false;
                } else {
                    hasChanged = true;
                    if (i == 1) {
                        continue;
                    } else if (i == nums.length - 1) {
                        return true;
                    } else if (nums[i] >= nums[i - 2]) {
                        nums[i - 1] = nums[i];
                    } else if (nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
