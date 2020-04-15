public class Q0485_MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == 1) {
                current++;
                i++;
            }

            max = Math.max(current,max);
            current = 0;
        }
        return max;
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int max = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, i - prev - 1);
                prev = i;
            }
        }

        return Math.max(nums.length - prev - 1, max);
    }
}
