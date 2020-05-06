public class Q0080_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 双指针法,length在左,i在右
        // length记录修改后数组的长度，也是下一个不重复数字应该放的位置
        int length = 0;
        // time记录最近的元素current已经出现的次数
        int current = nums[0];
        int time = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == current) {
                time++;
            } else {
                current = nums[i];
                time = 1;
            }

            if (time <= 2) {
                nums[length++] = nums[i++];
            } else {//current已经出现两次以上
                while(i < nums.length && nums[i] == current) {
                    i++;
                }
            }
        }

        return length;
    }
}
