import java.util.ArrayList;
import java.util.List;

public class Q0057_InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        if (intervals == null || intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        List<Integer[]> res = new ArrayList<>();
        int len = intervals.length;

        int l = len;
        while (l - 1 >= 0 && intervals[l - 1][1] >= newInterval[0]) l--;
        for (int i = 0; i < l; i++) {
            res.add(new Integer[]{intervals[i][0], intervals[i][1]});
        }
        if (l == len) {
            res.add(new Integer[]{newInterval[0], newInterval[1]});
            return getArray(res);
        } else if (intervals[l][0] > newInterval[1]) {
            res.add(new Integer[]{newInterval[0], newInterval[1]});
            for (int i = l; i < len; i++) {
                res.add(new Integer[]{intervals[i][0], intervals[i][1]});
            }
            return getArray(res);
        }

        Integer[] it = new Integer[2];
        it[0] = l < 0 ? newInterval[0] : Math.min(intervals[l][0], newInterval[0]);
        while (l + 1 < len && intervals[l + 1][0] <= newInterval[1]) l++;
        it[1] = Math.max(intervals[l][1], newInterval[1]);
        res.add(it);
        for (int i = l + 1; i < len; i++) {
            res.add(new Integer[]{intervals[i][0], intervals[i][1]});
        }

        return getArray(res);
    }

    private static int[][] getArray(List<Integer[]> list) {

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Integer[] cur = list.get(i);
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{3,5}, {12,15}};
        int[] arr2 = {6,6};
        insert(arr1, arr2);
    }
}
