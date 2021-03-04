import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        //排序加动态规划
        int n = envelopes.length;
        //(w,h),按w升序，h降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; i++) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = search(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int search(List<Integer> f, int tar) {
        //找到第一个比tar大的位置
        //例如将6插入 1 3 5 7，则返回3
        int l = 0, r = f.size() - 1;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (f.get(mid) < tar) {
                l = mid + 1;
            } else {
                if (mid - 1 >= l && f.get(mid - 1) < tar) {
                    l = mid;
                    break;
                }
                r = mid - 1;
            }
        }
        return l;
    }
}
