import java.util.HashMap;

public class Q0873_LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        //官方题解，动态规划
        int N = A.length;
        HashMap<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < N; i++) {
            index.put(A[i],i);
        }

        //将(i,j)编码为i * N + j存放在longest
        //value是以i,j结尾的斐波那契数列最长的长度
        HashMap<Integer,Integer> longest = new HashMap<>();
        int max = 0;
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault
                        (A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int cur = longest.getOrDefault
                            (i * N + j, 2) + 1;
                    longest.put(j * N + k, cur);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}
