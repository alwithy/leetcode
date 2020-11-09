import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k < 1) {
            return new int[0][0];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1];
            }
        });
        for (int i = 0; i < points.length; i++) {
            if (queue.size() < k) {
                queue.add(points[i]);
            } else if (closer(points[i], queue.peek())) {
                queue.poll();
                queue.add(points[i]);
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public boolean closer(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1] < 0;
    }
}
