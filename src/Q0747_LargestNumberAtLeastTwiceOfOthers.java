public class Q0747_LargestNumberAtLeastTwiceOfOthers {
    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //max保留最大的两个数字的索引
        int[] max = new int[2];
        max[0] = nums[0] > nums[1] ? 0 : 1;
        max[1] = max[0] ^ 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max[1]]) {
                if (nums[i] > nums[max[0]]) {
                    max[1] = max[0];
                    max[0] = i;
                } else {
                    max[1] = i;
                }
            }
            if (nums[max[1]] > 50) {
                return -1;
            }
        }
        return nums[max[0]] >= 2 * nums[max[1]] ? max[0] : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,0};
        System.out.println(
                dominantIndex(arr));
    }
}
