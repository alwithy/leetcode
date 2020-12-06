import java.util.ArrayList;
import java.util.List;

public class Q0118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(cur);
        if (numRows == 1) return res;
        cur = new ArrayList<>();
        cur.add(1);
        cur.add(1);
        res.add(cur);
        List<Integer> last;
        while (res.size() < numRows) {
             last = res.get(res.size() - 1);
             cur = new ArrayList<>();
             cur.add(1);
            for (int i = 1; i < res.size(); i++) {
                cur.add(last.get(i) + last.get(i - 1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
