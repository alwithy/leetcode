import java.util.ArrayDeque;
import java.util.Deque;

public class Q0084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        if (heights == null || heights.length == 0) return res;
        int len = heights.length;
        // 使用单调栈快速寻找左右边界
        // 寻找左边界时，从左往右遍历，栈顶到栈底递减
        // 寻找右边界时，从右往左遍历， 栈顶到栈底递减
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }
}
