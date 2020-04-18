package search;

import java.util.Arrays;

public class BinarySearchExamples {
    public static int search1(int[] nums, int k) {
        //找到比k小的最大数字
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length;
        int mid;
        while (r >= l) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] >= k) {
                r = mid + 1;
            } else {
                l = mid - 1;
            }
        }
        return l - 1;//比k小的最大数字

    }
}
