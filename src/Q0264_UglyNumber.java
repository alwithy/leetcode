import java.util.HashSet;
import java.util.PriorityQueue;

public class Q0264_UglyNumber {
    int[] num;

    public Q0264_UglyNumber() {
        num = new int[1690];
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        for (int i = 0; i < num.length; i++) {
            long cur = queue.poll();
            num[i] = (int) cur;

            if (!set.contains(cur * 2)) {
                queue.add(cur * 2);
                set.add(cur * 2);
            }

            if (!set.contains(cur * 3)) {
                queue.add(cur * 3);
                set.add(cur * 3);
            }

            if (!set.contains(cur * 5)) {
                queue.add(cur * 5);
                set.add(cur * 5);
            }
        }
    }

    public int nthUglyNumber(int n) {
        return num[n - 1];
    }

    public static void main(String[] args) {
        Q0264_UglyNumber q = new Q0264_UglyNumber();
        System.out.println(q.nthUglyNumber(10));
    }
}
