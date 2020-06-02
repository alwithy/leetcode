public class Q0915_PartitionArrayIntoDisjointIntervals {
    public static int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // 使用两个数组，prev和next
        // prev[i]代表A中从0到i - 1中的最大的值
        // next[i]代表A中从i到最后一个元素中的最小值
        // prev数组可以用一个变量代替
        int res = 0;

        int[] next = new int[A.length];
        next[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            next[i] = Math.min(next[i + 1], A[i]);
        }

        int prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (prev <= next[i]) {
                res = i;
                break;
            }
            prev = Math.max(prev, A[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(partitionDisjoint(arr));
    }
}
