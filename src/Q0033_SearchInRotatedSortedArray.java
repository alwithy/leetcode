public class Q0033_SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        //首先找到数组中的最小值，即旋转前的第一个元素
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {//nums[mid] < nums[r]
                r = mid;
            }
        }

        //l即为数组中最小的元素，将数组分为两段，再二分查找
        int min = l;
        if (target <= nums[nums.length - 1]) {
            l = min;
            r = nums.length - 1;
        } else {
            l = 0;
            r = min - 1;
        }

        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {//target == nums[mid]
                return mid;
            }
        }

        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(search(arr,2));
    }
}
