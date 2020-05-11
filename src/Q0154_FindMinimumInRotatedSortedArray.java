public class Q0154_FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            mid = left + ((right - left) >> 1);
            if (mid == left) {
                return Math.min(nums[left], nums[right]);
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            } else if (nums[mid] == nums[right]) {
                right--;
                continue;
            }
            // 两种情况可以合并
            if (nums[left] == nums[right]) {
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else {
                    // nums[mid] < nums[left]
                    right = mid;
                }
            } else {
                // nums[left] > nums[right]
                if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    // nums[mid] <= nums[right]
                    // 因为运行到此处的前提是nums[left] > nums[right]
                    right = mid;
                }
            }
        }

        return nums[left];
    }



    public static void main(String[] args) {
        int[] arr = {10,10,10,-10,-10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,9,9,9,9,9,10,10};
        findMin(arr);
    }
}
