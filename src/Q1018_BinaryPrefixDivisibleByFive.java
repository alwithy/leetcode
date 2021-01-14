import java.util.ArrayList;
import java.util.List;

public class Q1018_BinaryPrefixDivisibleByFive {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        int sum = A[0];
        int mod = (int) Math.pow(5, 10);
        List<Boolean> res = new ArrayList<>();
        res.add(sum == 0);
        for (int i = 1; i < A.length; i++) {
            sum = (sum * 2 + A[i]) % mod;
            res.add(sum % 5 == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,0,1,0,0,1};
        List<Boolean> res = prefixesDivBy5(arr);
    }
}
