import java.util.Arrays;
import java.util.Comparator;

public class Q0435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int right = intervals[0][1];//最近选择的区间的右边界
        int count = 1;//已经选择的区间数量
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
