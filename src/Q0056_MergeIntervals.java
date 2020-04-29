import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0056_MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, new MyComparator());
        int i = 0;
        int[] cur;
        while (i < intervals.length) {
            if (i > 0 && intervals[i][0] == intervals[i - 1][0]) {
                i++;
                continue;
            }

            cur = intervals[i];
            while (i + 1< intervals.length && cur[1] >= intervals[i + 1][0]) {
                i++;
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            res.add(cur);
            i++;
        }

        return res.toArray(new int[0][]);
    }

    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public static void main(String[] args) {
        int[][] merge = {{1,3},{2,6},{8,10},{15,18}};
        merge = merge(merge);
    }
}
