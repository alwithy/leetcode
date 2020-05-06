public class Q0081_SearchInRotatedArray {
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }

            // 若前半部分有序
            if (nums[left] < nums[mid]) {
                // 若target在前半部分
                if (nums[mid]  > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // nums[left] > nums[mid],后半部分有序
                // 若target在后半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,1,1};
        System.out.println(search(arr, 3));
        //System.out.println(searchMin(arr, 0, 3));
    }
}
