import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q1356_SortIntegersByNumberOfOne {
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        List<Integer> list = new LinkedList<>();
        for (int i : arr) {
            list.add(i);
        }
        int[] bit = new int[10001];
        for (int i = 0; i < bit.length; i++) {
            bit[i] = bit[i >> 1] + (i&1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (bit[a] != bit[b]) {
                    return bit[a] - bit[b];
                } else {
                    return a - b;
                }
            }
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
