public class Q0031_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                //找到nums[i + 1]之后比nums[i]大的最小值与nums[i]交换
                int j = i + 1;
                while (j + 1 < nums.length && nums[j + 1] > nums[i]) j++;
                swap(nums, i, j);
                //nums[i + 1]到nums[length - 1]的元素要逆序
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    swap(nums,l,r);
                    l++;
                    r--;
                }
                return;
            }

        }

        //直到循环结束都没return，说明已经是最大字典序
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        nextPermutation(arr);
    }
}
