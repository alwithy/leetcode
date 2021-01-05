import java.util.ArrayList;
import java.util.List;

public class Q0315_CountOfSmallerNumbersAfterSelf {
    private static int[] arr;
    private static int[] indexes;
    private static int[] counts;

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //归并排序
        arr = nums;
        int n = nums.length;
        indexes = new int[n];
        counts = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(0, n - 1);

        for (int num : counts) {
            res.add(num);
        }

        return res;
    }

    private static void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        //计算逆序对
        //p1和p2只往左移动
        int p1 = mid, p2 = r;
        while (p1 >= l && p2 > mid) {
            while (p2 > mid && arr[p2] >= arr[p1]) {
                p2--;
            }
            if (p2 == mid) break;
            counts[indexes[p1]] += p2 - mid;
            p1--;
        }

        //合并,nums和index中的元素保持对应关系
        int[] helpNum = new int[r - l + 1];
        int[] helpIndex = new int[r - l + 1];
        p1 = l;
        p2 = mid + 1;
        int p3 = 0;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                helpNum[p3] = arr[p1];
                helpIndex[p3++] = indexes[p1++];
            } else {
                helpNum[p3] = arr[p2];
                helpIndex[p3++] = indexes[p2++];
            }
        }
        while (p1 <= mid) {
            helpNum[p3] = arr[p1];
            helpIndex[p3++] = indexes[p1++];
        }
        while (p2 <= r) {
            helpNum[p3] = arr[p2];
            helpIndex[p3++] = indexes[p2++];
        }
        p1 = l;
        while (p1 <= r) {
            arr[p1] = helpNum[p1 - l];
            indexes[p1] = helpIndex[p1 - l];
            p1++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        List<Integer> res = countSmaller(arr);
    }
}
