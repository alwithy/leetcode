import java.util.Deque;
import java.util.LinkedList;

public class Q1438_LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0 || limit < 0) {
            return 0;
        }
        //滑动窗口+单调队列
        //窗口范围为[l..r]
        int l = 0;
        //队首为最小值，队首到队尾单调递增
        Deque<Integer> min = new LinkedList<>();
        //队首为最大值，队首到队尾单调递减
        Deque<Integer> max = new LinkedList<>();
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[r]) {
                min.pollLast();
            }
            min.addLast(r);

            while (!max.isEmpty() && nums[max.peekLast()] <= nums[r]) {
                max.pollLast();
            }
            max.addLast(r);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                l++;
                while (max.peekFirst() < l) {
                    max.pollFirst();
                }
                while (min.peekFirst() < l) {
                    min.pollFirst();
                }
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
