import java.util.LinkedList;
import java.util.List;

public class Q0057_InsertInterval {
    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        if (intervals == null || intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};

        List<int[]> res = new LinkedList<>();
        int i = 0;
        int len = intervals.length;
        // 未合并时
        while (i < len) {
            if (intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = null;
                break;
            } else if (needMerge(intervals[i], newInterval)) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            } else {
                res.add(intervals[i]);
            }
            i++;
        }

        while (i < len) res.add(intervals[i++]);
        if (newInterval != null) res.add(newInterval);
        int[][] arr = new int[res.size()][2];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = res.get(j);
        }
        return arr;
    }

    public static boolean needMerge(int[] a, int[] b) {
        return !(a[1] < b[0] || a[0] > b[1]);
    }

    public static void main(String[] args) {
        int[][] arr1 = {{3,5}, {12,15}};
        int[] arr2 = {6,6};
        insert1(arr1, arr2);
    }
}
