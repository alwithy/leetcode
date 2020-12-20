import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q5631_JumpGame {
    public static int maxResult(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        int len = nums.length;
        int res = nums[0];
        int i = 0, j = 0;
        //大根堆，堆顶最大
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        while (i < len - 1) {
            j = i + 1;
            //寻找下一个非负数
            while (j < len && nums[j] < 0) {
                j++;
            }
            //j为下一次的目的地,nums[i + 1..j - 1]全是负数
            if (j == len) {
                j--;
            }
            if (j <= i + k) {
                res += nums[j];
                i = j;
                continue;
            }

            //dp[l - i]表示从nums[i]到nums[l]的最小代价
            int[] dp = new int[j - i + 1];
            heap.add(i);
            for (int l = i + 1; l <= j; l++) {
                while (!heap.isEmpty() && heap.peek() < l - k) {
                    heap.poll();
                }
                dp[l - i] = dp[heap.peek() - i] + nums[l];
                heap.add(l);
            }
            res += dp[j - i];
            i = j;
        }
        return res;
    }

    //使用单调栈，时间O(n),空间O(n)
    public static int maxResult1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        int len = nums.length;
        int res = nums[0];
        int i = 0, j = 0;
        //单调队列，从队首带队尾，index递增，dp[]递减
        Deque<Integer> deque = new LinkedList<>();
        while (i < len - 1) {
            j = i + 1;
            //寻找下一个非负数
            while (j < len && nums[j] < 0) {
                j++;
            }
            //j为下一次的目的地,nums[i + 1..j - 1]全是负数
            if (j == len) {
                j--;
            }
            if (j <= i + k) {
                res += nums[j];
                i = j;
                continue;
            }

            //dp[l - i]表示从nums[i]到nums[l]的最小代价
            int[] dp = new int[j - i + 1];
            deque.push(i);
            for (int l = i + 1; l <= j; l++) {
                while (!deque.isEmpty() && deque.peekFirst() < l - k) {
                    deque.pollFirst();
                }
                dp[l - i] = dp[deque.peekFirst() - i] + nums[l];
                while (!deque.isEmpty() && dp[deque.peekLast() - i] <= dp[l - i]) {
                    deque.pollLast();
                }
                deque.addLast(l);
            }
            deque.clear();
            res += dp[j - i];
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,-5,-20,4,-1,3,-6,-3};
        System.out.println(maxResult(arr, 2));
        System.out.println(maxResult1(arr, 2));
    }
}
