import java.util.ArrayDeque;
import java.util.Deque;

public class Q0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        int[] res = new int[T.length];
        // 官方题解2，单调栈,栈顶到栈底递增
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            while (!deque.isEmpty() && T[i] > T[deque.peek()]) {
                int prv = deque.pop();
                res[prv] = i - prv;
            }
            deque.push(i);
        }

        return res;
    }
}
