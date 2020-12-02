import java.util.Deque;
import java.util.LinkedList;

public class Q0321_CreateMaximumNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l = Math.max(0, k - len2), r = Math.min(len1, k);
        for (int i = l; i <= r; i++) {
            int[] n1 = maxSequence(nums1, i);
            int[] n2 = maxSequence(nums2, k - i);
            int[] cur = merge(n1, n2);
            if (compare(cur, res)) {
                res = cur;
            }
        }
        return res;
    }

    public static int[] maxSequence(int[] arr, int len) {
        if (len == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        for (; i < arr.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < arr[i]
                    && arr.length - i > len - deque.size()) {
                deque.pollLast();
            }
            if (deque.size() < len) {
                deque.addLast(arr[i]);
            }
        }
        int[] res = new int[len];
        for (i = 0; i < len; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }

    public static int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    //若n1 > n2 或者n2为null,返回true
    public static boolean compare(int[] n1, int[] n2) {
        if (n2 == null) {
            return true;
        }
        int i = 0;
        while (i < n1.length) {
            if (n1[i] != n2[i]) {
                return n1[i] > n2[i];
            }
            i++;
        }
        return false;
    }

    public static int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    public static void main(String[] args) {
        //int[] nums1 = {3,4,6,5};
        int[] nums1 = {8,6,9};
        //int[] nums2 = {9,1,2,5,8,3};
        int[] nums2 = {1,7,5};
        int k = 3;
        int[] res = maxNumber(nums1, nums2, k);
    }
}
