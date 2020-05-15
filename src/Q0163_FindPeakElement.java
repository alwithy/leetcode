public class Q0163_FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 判断特例
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            // 每次都先判断left,right是否符合条件
            if (nums[left] > nums[left + 1]
                    && (left == 0 || nums[left] > nums[left - 1])) {
                break;
            }
            if (nums[right] > nums[right - 1]
                    && (right == nums.length - 1 || nums[right] > nums[right + 1])) {
                left = right;
                break;
            }
            mid = left + ((right - left) >> 1);
            // 如果mid为峰值
            if (nums[mid] > Math.max(nums[mid - 1], nums[mid + 1])) {
                left = mid;
                break;
            } else if (nums[mid] > nums[mid - 1]
                    && nums[mid] < nums[mid + 1]) {
                // mid处于递增区间
                left = mid + 1;
            } else {
                // mid处于递减区间
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,3,2,1};
        int res = findPeakElement(arr);
    }
}
