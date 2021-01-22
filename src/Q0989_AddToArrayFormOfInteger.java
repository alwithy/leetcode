import java.util.ArrayList;
import java.util.List;

public class Q0989_AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int bit = 1;
        int i = 0;
        int bring = 0;//进位
        List<Integer> res = new ArrayList<>();
        int len = A.length;
        while (i < len || bit <= K || bring == 1) {
            int cur = bring;
            bring = 0;
            if (i < len) {
                cur += A[len - i - 1];
                i++;
            }
            if (bit <= K) {
                cur += (K / bit) % 10;
                bit *= 10;
            }
            if (cur >= 10) {
                cur -= 10;
                bring = 1;
            }
            res.add(cur);
        }
        i = 0;
        int j = res.size() - 1;
        while (i < j) {
            int tmp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, tmp);
            i++;
            j--;
        }
        return res;
    }
}
