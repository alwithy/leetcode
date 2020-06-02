import java.util.ArrayDeque;
import java.util.Deque;

public class Q0907_SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int res = 0;
        int MOD = 1_000_000_007;
        if (A == null || A.length == 0) {
            return res;
        }
        // 官方题解一，使用前驱和后继数组
        int[] prev = new int[A.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            while (!deque.isEmpty() && A[i] <= A[deque.peek()]) {
                deque.poll();
            }
            prev[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }

        deque = new ArrayDeque<>();
        int[] next = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && A[i] < A[deque.peek()]) {
                deque.poll();
            }
            next[i] = deque.isEmpty() ? A.length : deque.peek();
            deque.push(i);
        }

        for (int i = 0; i < A.length; i++) {
            res += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            res %= MOD;
        }

        return res;
    }
}
