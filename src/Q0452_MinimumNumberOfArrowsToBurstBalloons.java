import java.util.Arrays;
import java.util.Comparator;

public class Q0452_MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        //按右边界从小到大排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int res = 0;
        int pos = points[0][1];
        for (int[] arr : points) {
            if (pos < arr[0]) {
                res++;
                pos = arr[1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(arr));
    }
}
