public class Q0075_SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 遍历一次数组
        // 指针red指向红色部分的右边界
        int red = -1;
        // 指针blue指向蓝色部分的左边界
        int blue = nums.length;
        int i = 0;
        while (i < blue) {
            if (nums[i] == 0) {
                swap(nums, i, ++red);
            } else if (nums[i] == 2) {
                swap(nums, i, --blue);
            }
            // 指针i前进的条件是red右边界已经到达i
            // 或者目前nums[i]的值为1，因为我们要保证所有的2已经挪到最右边
            if (nums[i] == 1 || red == i) {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
