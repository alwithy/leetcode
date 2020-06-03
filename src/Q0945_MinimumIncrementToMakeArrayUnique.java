import java.util.Arrays;

public class Q0945_MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        if (A == null || A.length <= 1) {
            return res;
        }
        Arrays.sort(A);
        int taken = 0; // 当前的重复元素数量
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                taken++;
                res -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i - 1] - 1);
                res += give * (give + 1)/ 2 + give * A[i - 1];
                taken -= give;
            }
        }

        if (taken > 0) {
            res += taken * (taken + 1)/ 2 + taken * A[A.length - 1];
        }

        return res;
    }
}
