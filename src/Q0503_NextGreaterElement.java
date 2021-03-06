import java.util.ArrayDeque;
import java.util.Deque;

public class Q0503_NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        //单调栈，遍历数组两次
        int n = nums.length;
        int[] res = new int[n];
        boolean[] hasBigger = new boolean[n];
        //queue中存放index，栈顶到栈底递增
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                int poll = queue.pollLast();
                res[poll] = nums[i];
                hasBigger[poll] = true;
            }
            queue.addLast(i);
        }

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                int poll = queue.pollLast();
                res[poll] = nums[i];
                hasBigger[poll] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!hasBigger[i]) {
                res[i] = -1;
            }
        }
        return res;
    }
}
