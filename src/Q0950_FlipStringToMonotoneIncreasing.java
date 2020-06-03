public class Q0950_FlipStringToMonotoneIncreasing {
    public static int minFlipsMonoIncr(String S) {
        if (S == null || S.length() <= 1) {
            return 0;
        }
        // 官方题解1，前缀和
        int[] P = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            P[i + 1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= S.length(); i++) {
            res = Math.min(res,
                    P[i] + S.length() - i - (P[S.length()] - P[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "010110";

        System.out.println(minFlipsMonoIncr(S));
    }
}
