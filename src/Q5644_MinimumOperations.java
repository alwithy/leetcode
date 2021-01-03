import java.util.HashMap;

public class Q5644_MinimumOperations {
    public int minOperations(int[] target, int[] arr) {
        if (arr == null || arr.length == 0) {
            return target == null ? 0 : target.length;
        }
        //将arr的数字转化为在target中的index,然后求出最长严格递增子序列
        //若arr[i]在target中不存在，则标记为-1
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.getOrDefault(arr[i], -1);
        }
        //len是目前发现的最长上升子序列的长度
        int len = 0;
        //长度为len的上升子序列的最后一个数字的最小值是is[len - 1]
        int[] is = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                continue;
            }
            if (len == 0 || arr[i] > is[len - 1]) {
                len++;
                is[len - 1] = arr[i];
                continue;
            }

            //二分查找L满足is[L - 1] < arr[i] < is[L]，然后更新is[L]
            int l = 0;
            int r = len - 1;
            int mid;
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (is[mid] < arr[i]) {
                    l = mid + 1;
                } else {
                    if (mid - 1 >= l && is[mid - 1] < arr[i]) {
                        l = mid;
                        break;
                    }
                    r = mid - 1;
                }
            }
            is[l] = arr[i];
        }

        return target.length - len;
    }
}
