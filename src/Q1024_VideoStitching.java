public class Q1024_VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        if (clips == null || T < 0) return -1;
        int[] max = new int[T];
        for (int[] arr : clips) {
            if (arr[0] < T) max[arr[0]] = Math.max(max[arr[0]], arr[1]);
        }

        int last = 0; // 当前能到达的最远位置
        int pre = 0; // 上一个使用的区间的右端点
        int count = 0; // 使用的区间数量
        for (int i = 0; i < T; i++) {
            last = Math.max(last, max[i]);
            if (last == i) {
                return -1;
            }

            if (pre == i) {
                // 启用新区间
                pre = last;
                count++;
            }
        }

        return count;
    }
}
