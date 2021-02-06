public class Q1744_CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int m = queries.length;
        //preSum[i]表示candy[0..i - 1]之和
        long[] preSum = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i - 1];
        }
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            //想吃q[0]，在q[1]天，每天最多吃q[2]
            //q[1]前最少吃q[1]，在q[1]天最多吃到第q[2] * (q[1] + 1)个
            //q[0]类型是从preSum[0..q[0] - 1]到preSum[0..q[0]]
            //有交集为true,否则false
            if (q[1] >= preSum[q[0] + 1] || (long)q[2] * (q[1] + 1) <= preSum[q[0]]) {
                res[i] = false;
            } else {
                res[i] = true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] candy = {16,38,8,41,30,31,14,45,3,2,24,23,38,30,31,17,35,4,9,42,28,18,37,18,14,46,11,13,19,3,5,39,24,48,20,29,4,19,36,11,28,49,38,16,23,24,4,22,29,35,45,38,37,40,2,37,8,41,33,8,40,27,13,4,33,5,8,14,19,35,31,8,8};
        int[][] q = {{43,1054,49}};
        boolean[] res = canEat(candy, q);
    }
}
