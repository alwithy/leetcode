import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q0962_MaximumWidthRamp {
    public int maxWidthRamp1(int[] A) {
        if (A == null || A.length == 0) return 0;
        // 排序
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = i;
        }
        Arrays.sort(B, (i, j) -> ((Integer)A[i]).compareTo((Integer)A[j]));
        int res = 0;
        int min = B[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(B[i] - min, res);
            min = Math.min(min, B[i]);
        }

        return res;
    }

    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) return 0;
        // 单调栈，最大坡度的坡底一定是在以A[0]开头的递减序列中
        // 我们保存这个序列，然后逆序遍历，当前数字大于等于栈顶元素的时候就不断弹出，
        // 然后计算坡度
        // 时间O(n),空间O(n)
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            if (deque.isEmpty() || A[i] < A[deque.peek()]) {
                deque.push(i);
            }
        }

        int res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && A[i] >= A[deque.peek()]) {
                int cur = deque.pop();
                res = Math.max(res, i - cur);
            }
        }

        return res;
    }
}
