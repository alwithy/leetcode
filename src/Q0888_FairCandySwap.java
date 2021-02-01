import java.util.HashSet;

public class Q0888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : A) {
            sum += num;
            set.add(num);
        }
        for (int num : B) {
            sum -= num;
        }
        // x = y + (sumA - sumB)/2
        sum /= 2;
        for (int num : B) {
            if (set.contains(num + sum)) {
                res[0] = num + sum;
                res[1] = num;
                break;
            }
        }

        return res;
    }
}
