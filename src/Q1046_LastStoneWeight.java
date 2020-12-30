import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            queue.add(i);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (queue.isEmpty()) {
                res = x;
                break;
            }
            int y = queue.poll();
            if (x != y) {
                queue.add(x - y);
            }
        }
        return res;
    }
}
