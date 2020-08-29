import java.util.LinkedList;
import java.util.List;

public class Q0060_PermutationSequence {
    public static String getPermutation(int n, int k) {
        if (n == 1) return "1";
        int help = 1;
        StringBuilder res = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            help *= i;
        }
        help /= n;
        while (n > 1) {
            int p = (k - 1)/help;
            res.append(list.get(p));
            list.remove(p);
            k -= Math.max(0, p) * help;
            help /= n - 1;
            n--;
        }
        if (!list.isEmpty()) res.append(list.get(0));

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }
}
