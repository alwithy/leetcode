public class Q0004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 官方题解1
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            int mid = (length + 1) >> 1;
            return findKthElement(nums1, nums2, mid);
        } else {
            int mid1 = (length + 1) >> 1;
            int mid2 = mid1 + 1;
            return (findKthElement(nums1,nums2,mid1) + findKthElement(nums1, nums2, mid2)) / 2.0;
        }
    }

    private double findKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }

            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 通常情况
            int halfK = k/2;
            int newIndex1 = Math.min(index1 + halfK - 1, nums1.length - 1);
            int newIndex2 = Math.min(index2 + halfK - 1, nums2.length - 1);
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
