public class Q0153_FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                //nums[mid] < nums[left]
                right = mid;
            } else {
                left = nums[left] < nums[right] ? left : right;
                break;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,-1};
        System.out.println(findMin(arr));
    }
}
