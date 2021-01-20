public class Q0274_HIndex {
    public int hIndex(int[] citations) {
        //计数法，时间O(N)，空间O(N)
        int n = citations.length;
        int[] count = new int[n + 2];
        for (int citation : citations) {
            count[Math.min(n, citation)]++;
        }
        int res = 0;
        for (int i = n; i >= 0; i--) {
            count[i] += count[i + 1];
            if (count[i] >= i) {
                res = i;
                break;
            }
        }
        return res;
    }
}
