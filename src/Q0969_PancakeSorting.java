import java.util.ArrayList;
import java.util.List;

public class Q0969_PancakeSorting {
    public static List<Integer> pancakeSort(int[] A) {
        // 每次都把最大的元素翻转到最后，最多需要翻转2 * A.length - 1次
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) return  res;
        for (int i = A.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }

            if (max == i) continue;
            if (max > 0) {
                pancakeSort(A, max + 1);
                res.add(max + 1);
            }

            pancakeSort(A, i + 1);
            res.add(i + 1);
        }

        return res;
    }

    private static void pancakeSort(int[] A, int k) {
        // 翻转前k位
        int left = 0;
        int right = k - 1;
        int temp;
        while (left < right) {
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        List<Integer> res = pancakeSort(arr);
    }
}
