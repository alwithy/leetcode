public class Q0041_FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        // 官方题解

        // 查找数组中有无1
        boolean hasOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne) {
            return 1;
        }

        // 将负数和0替换为1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }

        // 若存在正数i，则nums[i]标为负数
        // 若存在正数nums.length，则nums[0]标为负数
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num == nums.length) {
                if (nums[0] > 0) {
                    nums[0] *= -1;
                }
            } else if (num >= 1 && num <= nums.length - 1) {
                if (nums[num] > 0) {
                    nums[num] *= -1;
                }
            }
        }

        // 检查角标的符号，寻找缺失正数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return nums.length;
        } else {
            return nums.length + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr));
    }
}
