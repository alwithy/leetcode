import java.util.ArrayList;
import java.util.List;

public class Q0119_PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (; rowIndex > 0; rowIndex--) {
            if (cur.size() < 2) {
                cur.add(1);
                continue;
            }

            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int i = 0; i < cur.size() - 1; i++) {
                next.add(cur.get(i) + cur.get(i + 1));
            }
            next.add(1);
            cur = next;
        }

        return cur;
    }
}
